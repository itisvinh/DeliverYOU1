package com.deliveryou.controller;

import com.deliveryou.pojo.*;
import com.deliveryou.pojo.deliveryobject.PostDeliveryObject;
import com.deliveryou.service.implementations.UserServiceImpl;
import com.deliveryou.service.interfaces.*;
import com.deliveryou.util.JSONConverter;
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
        Address senderAddress = new Address() {{
            setProvince(postDeliveryObject.getSenderProvince());
            setDistrict(postDeliveryObject.getSenderDistrict());
            setWard(postDeliveryObject.getSenderWard());
            setStreet(postDeliveryObject.getSenderStreet());
        }};
        // add sender address
        addressService.addAddress(senderAddress);
        // create receiver address
        Address receiverAddress = new Address() {{
            setProvince(postDeliveryObject.getReceiverProvince());
            setDistrict(postDeliveryObject.getReceiverDistrict());
            setWard(postDeliveryObject.getReceiverWard());
            setStreet(postDeliveryObject.getReceiverStreet());
        }};
        // add receiver address
        addressService.addAddress(receiverAddress);
        // get category
        Category category = categoryService.getCategory(postDeliveryObject.getCategoryName());
        // create post
        Post post = new Post() {{
            setUser(userServiceImpl.getUser(1));
            setSenderAddress(senderAddress);
            setReceiverAddress(receiverAddress);
            setReceiverName(postDeliveryObject.getReceiverName());
            setReceiverPhone(postDeliveryObject.getReceiverPhone());
            setContent(postDeliveryObject.getPostContent().trim());
            setCategory(category);
            setOrderDate(new Timestamp(new Date().getTime()));
            setPromotion(null);
            setPaymentMethod(paymentMethodService.getPaymentMethod(PaymentMethod.CASH_ON_DELIVERY));
            setStatus(statusService.getStatus(Status.PENDING));
        }};
        // add post

        // ----------------------------------------------------
        boolean postCreatedSuccessfully = (postServiceImpl.addPost(post) == -1) ? false : true;
        if (postCreatedSuccessfully)
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
