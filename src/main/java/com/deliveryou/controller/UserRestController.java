package com.deliveryou.controller;

import com.deliveryou.pojo.*;
import com.deliveryou.pojo.deliveryobject.PostDeliveryObject;
import com.deliveryou.service.interfaces.*;
import com.deliveryou.util.JSONConverter;
import com.deliveryou.util.ConditionalChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/api")
public class UserRestController {
    @Autowired
    private PostService postServiceImpl;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PaymentMethodService paymentMethodService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private PostImageService postImageService;

    @Transactional
    @PostMapping(path = "/add-post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPost(@RequestBody PostDeliveryObject postDeliveryObject) {
        // create sender address
        Address senderAddress = new Address();
        // create receiver address
        Address receiverAddress = new Address();
        // get category
        Category category = categoryService.getCategory(postDeliveryObject.getCategoryName());
        // create post
        Post post = new Post();
        List<Integer> postCreatedSuccessfully = new ArrayList<>(2);

        ConditionalChain
                .begin("creating post chain")
                .then(() -> {
                    senderAddress.setProvince(postDeliveryObject.getSenderProvince());
                    senderAddress.setDistrict(postDeliveryObject.getSenderDistrict());
                    senderAddress.setWard(postDeliveryObject.getSenderWard());
                    senderAddress.setStreet(postDeliveryObject.getSenderStreet());
                    // add sender address
                    return addressService.addAddress(senderAddress) > 0;
                })
                .then(() -> {
                    receiverAddress.setProvince(postDeliveryObject.getReceiverProvince());
                    receiverAddress.setDistrict(postDeliveryObject.getReceiverDistrict());
                    receiverAddress.setWard(postDeliveryObject.getReceiverWard());
                    receiverAddress.setStreet(postDeliveryObject.getReceiverStreet());
                    // add receiver address
                    return addressService.addAddress(receiverAddress) > 0;
                })
                .then(() -> {
                    post.setUser(userServiceImpl.getUser(2));
                    post.setSenderAddress(senderAddress);
                    post.setReceiverAddress(receiverAddress);
                    post.setReceiverName(postDeliveryObject.getReceiverName());
                    post.setReceiverPhone(postDeliveryObject.getReceiverPhone());
                    post.setContent(postDeliveryObject.getPostContent().trim());
                    post.setCategory(category);
                    post.setOrderDate(new Timestamp(new Date().getTime()));
                    post.setPromotion(null);
                    post.setPaymentMethod(paymentMethodService.getPaymentMethod(PaymentMethod.CASH_ON_DELIVERY));
                    post.setStatus(statusService.getStatus(Status.PENDING));
                    // add post
                    int id = postServiceImpl.addPost(post);
                    boolean res = id > 0;
                    if (!res)
                        postCreatedSuccessfully.add(id);
                    return res;
                })
                .then(() -> {
                    List<String> urls = postDeliveryObject.getUrlList();
                    if (urls.size() > 0) {
                        int count = 0;
                        for (String url : urls) {
                            PostImage p = new PostImage();
                            p.setImage(url);
                            p.setPost(post);
                            if (postImageService.addPostImage(p) > 0)
                                count++;
                        }
                        postCreatedSuccessfully.add(count);
                    } else {
                        postCreatedSuccessfully.add(0);
                    }
                    return true;
                })
                .finish();

        if (postCreatedSuccessfully.size() > 0)
            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("message", "post is created successfully");
                put("code", HttpStatus.CREATED.value());
            }}), HttpStatus.CREATED);
        else
            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("message", "failed to create the post");
                put("code", HttpStatus.BAD_REQUEST.value());
            }}), HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @GetMapping(path = "/get-total-posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity totalPosts() {
        long totalPost = postServiceImpl.getTotalPosts();
        return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
            put("count", totalPost);
        }}), HttpStatus.OK);
    }

    @Transactional
    @GetMapping(path = "/get-post/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPost(@PathVariable("id") int id) {
        Post post = postServiceImpl.getPost(id);

        if (post != null) {
            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("post_created", post.getOrderDate().toString());
                put("pickup_loc", post.getSenderAddress().toString());
                put("dropoff_loc", post.getReceiverAddress().toString());
                put("rname", post.getReceiverName());
                put("rphone", post.getReceiverPhone());
                put("content", post.getContent());
                put("img_list", post.getPostImages().stream().map(postImage -> postImage.getImage()).collect(Collectors.toList()));
            }}), HttpStatus.OK);
        } else {
            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("error", "not found");
            }}), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    @GetMapping(path = "/get-current-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String phone = authentication.getName();
        User user = userServiceImpl.getUser(phone);

        if (user != null) {
            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("first_name", user.getFirstname());
                put("last_name", user.getLastname());
                put("phone", user.getPhoneNumber());
                put("id", user.getId());
            }}), HttpStatus.OK);
        } else {
            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("error", "failed to get user");
            }}), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
