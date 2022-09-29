package com.deliveryou.controller;

import com.deliveryou.pojo.User;
import com.deliveryou.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuocTestController {

    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signUp_Form";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute(value = "user") User user){
        if (this.userService.addUser(user)){
            return "redirect:/";
        }
        return "register";
    }

}
