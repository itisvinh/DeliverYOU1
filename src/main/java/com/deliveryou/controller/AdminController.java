package com.deliveryou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Transactional
    @GetMapping("/admin/app")
    public String adminRootPage() {
        return "admin";
    }

    @Transactional
    @GetMapping("/admin/app/admin-driver-3249738HJVHSG87629GCUYC987")
    public String adminDriverPage() {
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
