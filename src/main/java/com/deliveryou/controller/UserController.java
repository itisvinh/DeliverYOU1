package com.deliveryou.controller;

import com.cloudinary.Cloudinary;
import com.deliveryou.pojo.deliveryobject.PostDeliveryObject;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmOuterJoinEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/user/app")
    public String userPage() {
        return "user";
    }

    @RequestMapping("/user/app/user-posts-127FG8XsRgZ3230740279023749g13Yc")
    public String userPostsFrame(ModelMap modelMap) {
        modelMap.addAttribute("user_post", new PostDeliveryObject());
        return "user_posts";
    }

//    @PostMapping("/add-post")
//    public ResponseEntity<String> addPost(@ModelAttribute(value = "user_post") PostDeliveryObject postDeliveryObject) {
//        System.out.println(postDeliveryObject);
//        return new ResponseEntity<String>("ok", HttpStatus.OK);
//    }
}
