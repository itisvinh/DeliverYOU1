package com.deliveryou.controller;

import com.cloudinary.Cloudinary;
import com.deliveryou.deliveryobject.PostDeliveryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
