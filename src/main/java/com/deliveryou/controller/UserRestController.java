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
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

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
        StringBuilder postCreatedSuccessfully = new StringBuilder("");

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
                    post.setUser(userServiceImpl.getUser(1));
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
                    boolean res = postServiceImpl.addPost(post) > 0;
                    if (!res)
                        postCreatedSuccessfully.append("1");
                    return res;
                })
                .finish();

        if (postCreatedSuccessfully.toString().equals(""))
            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("message", "post is created successfully");
                put("post", post);
            }}), HttpStatus.CREATED);
        else
            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                put("message", "failed to create the post");
            }}), HttpStatus.BAD_REQUEST);
    }

}
