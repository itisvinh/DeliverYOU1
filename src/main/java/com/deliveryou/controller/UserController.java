package com.deliveryou.controller;

import com.cloudinary.Cloudinary;
import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.Status;
import com.deliveryou.pojo.deliveryobject.PostDeliveryObject;
import com.deliveryou.service.interfaces.PostService;
import com.deliveryou.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    private static final int posts_per_tab = 12;
    @Autowired
    private PostService postServiceImpl;
    @Autowired
    private StatusService statusServiceImpl;

    @GetMapping("/user/app")
    public String userPage() {
        return "user";
    }

    @RequestMapping("/user/app/user-posts-127FG8XsRgZ3230740279023749g13Yc")
    public String userPostsFrame(ModelMap modelMap) {
        Status ongoing = statusServiceImpl.getStatus(Status.ONGOING);
        Status pending = statusServiceImpl.getStatus(Status.PENDING);
        Status delivered = statusServiceImpl.getStatus(Status.DELIVERED);
        Status canceled = statusServiceImpl.getStatus(Status.CANCELED);

        modelMap.addAttribute("user_post", new PostDeliveryObject());

        List<Post> ongoing_list = postServiceImpl.getPostsWithinRange(ongoing, 0, posts_per_tab);
        List<Post> pending_list = postServiceImpl.getPostsWithinRange(pending, 0, posts_per_tab);
        List<Post> delivered_list = postServiceImpl.getPostsWithinRange(delivered, 0, posts_per_tab);
        List<Post> canceled_list = postServiceImpl.getPostsWithinRange(canceled, 0, posts_per_tab);

        modelMap.addAttribute("ongoing", ongoing_list);
        modelMap.addAttribute("pending", pending_list);
        modelMap.addAttribute("delivered", delivered_list);
        modelMap.addAttribute("canceled", canceled_list);

        return "user_posts";
    }

}
