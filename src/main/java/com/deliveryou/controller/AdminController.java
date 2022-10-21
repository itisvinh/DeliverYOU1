package com.deliveryou.controller;

import com.deliveryou.pojo.Role;
import com.deliveryou.pojo.User;
import com.deliveryou.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userServiceImpl;


    @Transactional
    @GetMapping("/admin/app")
    public String adminRootPage() {
        return "admin";
    }

    @Transactional
    @GetMapping("/admin/app/admin-driver-3249738HJVHSG87629GCUYC987")
    public String adminDriverPage(ModelMap modelMap) {

        return "admin_driver";
    }

    @Transactional
    @GetMapping("/admin/admin-reports-2398JHVCJHVJHK98702970JHVJHV9e")
    public String adminReportsPage() {
        return "admin_reports";
    }

    @Transactional
    @GetMapping("/admin")
    public String adminLoginPage() {
        return "administrator";
    }
}
