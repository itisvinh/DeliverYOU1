package com.deliveryou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
//@Transactional
public class HomeController {
    @RequestMapping("/")
    public ModelAndView index(@RequestParam Map<String, String> params) {
        ModelAndView  modelAndView = new ModelAndView("homePage");
        return modelAndView;
    }
}
