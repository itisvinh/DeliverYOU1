package com.deliveryou.controller;

import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.deliveryobject.PostDeliveryObject;
import com.deliveryou.util.JSONConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/api")
public class UserRestController {

    @PostMapping(path = "/add-post", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPost(@RequestBody PostDeliveryObject postDeliveryObject) {
        Post post = postDeliveryObject.convertToPost();
        System.out.println(post);

        boolean postCreatedSuccessfully = true;

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
