package com.deliveryou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @GetMapping("/user/app")
    public String userPage() {
        return "user";
    }

    @RequestMapping("/user/app/user-posts-127FG8XsRgZ3230740279023749g13Yc")
    public String userPostsFrame() {
        return "user_posts";
    }
}
