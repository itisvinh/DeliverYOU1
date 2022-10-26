package com.deliveryou.controller;

import com.deliveryou.pojo.Post;
import com.deliveryou.pojo.Status;
import com.deliveryou.pojo.User;
import com.deliveryou.pojo.deliveryobject.PostDeliveryObject;
import com.deliveryou.service.interfaces.PostService;
import com.deliveryou.service.interfaces.StatusService;
import com.deliveryou.service.interfaces.UserService;
import com.deliveryou.util.LazyLoadInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    private static final int posts_per_tab = 12;
    @Autowired
    private PostService postServiceImpl;
    @Autowired
    private StatusService statusServiceImpl;
    @Autowired
    private UserService userDetailsService;

    @GetMapping("/user/app")
    @Transactional
    public String userPage(ModelMap modelMap) {
        modelMap.addAttribute("total_posts", postServiceImpl.getTotalPosts());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String phone = authentication.getName();
        User user = userDetailsService.getUser(phone);
        modelMap.addAttribute("current_user", user);
        return "user";
    }

    @Transactional
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

        ongoing_list.forEach(post -> LazyLoadInitializer.lazyLoad(post.getPostImages()));
        pending_list.forEach(post -> LazyLoadInitializer.lazyLoad(post.getPostImages()));
        delivered_list.forEach(post -> LazyLoadInitializer.lazyLoad(post.getPostImages()));
        canceled_list.forEach(post -> LazyLoadInitializer.lazyLoad(post.getPostImages()));

        modelMap.addAttribute("ongoing", ongoing_list);
        modelMap.addAttribute("pending", pending_list);
        modelMap.addAttribute("delivered", delivered_list);
        modelMap.addAttribute("canceled", canceled_list);

        return "user_posts";
    }

    @Transactional
    @RequestMapping("/shipper/app/shipper-posts-12iefv92yygCGYC6758ygcfGUXCTUYX8769ckvb")
    public String shipperPostsFrame(Principal principal, ModelMap modelMap) {
        List<Post> pendingPosts = postServiceImpl.getPendingPostsForShipper(principal.getName());
        List<Post> awaitAcceptancePosts = postServiceImpl.getAwaitUserAcceptPostForShipper(principal.getName());
        List<Post> acceptedPosts = postServiceImpl.getUserAcceptedPostsForShipper(principal.getName());

        pendingPosts.forEach(post -> LazyLoadInitializer.lazyLoad(post.getPostImages()));
        awaitAcceptancePosts.forEach(post -> LazyLoadInitializer.lazyLoad(post.getPostImages()));
        acceptedPosts.forEach(post -> LazyLoadInitializer.lazyLoad(post.getPostImages()));

        modelMap.addAttribute("pending_posts", pendingPosts);
        modelMap.addAttribute("await_acceptance_posts", awaitAcceptancePosts);
        modelMap.addAttribute("accepted_posts", acceptedPosts);
        modelMap.addAttribute("u_phone", principal.getName());
        return "shipper_posts";
    }

    @GetMapping("/shipper/app")
    @Transactional
    public String shipperPage(ModelMap modelMap) {
        modelMap.addAttribute("total_posts", postServiceImpl.getTotalPosts());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String phone = authentication.getName();
        User user = userDetailsService.getUser(phone);
        modelMap.addAttribute("current_user", user);
        return "user";
    }

    @GetMapping("/user/app/user-profile-29347283hvUVUVUv982uvuVUYV39e8")
    @Transactional
    public String shipperProfile(ModelMap modelMap) {
        return "user_profile";
    }

    @GetMapping("/user/app/rating-shipper")
    @Transactional
    public String rateShipper(ModelMap modelMap) {
        return "rating_shipper";
    }
}
