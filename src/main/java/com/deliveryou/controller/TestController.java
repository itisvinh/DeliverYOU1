package com.deliveryou.controller;

import com.deliveryou.repository.interfaces.PostAuctionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Autowired
//    private PostAuctionsRepository postAuctionsRepositoryImpl;
//    @Autowired
//
//    @GetMapping("/1")
//    @Transactional
//    public ResponseEntity test1() {
//        postAuctionsRepositoryImpl.addPostAuction(null);
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
