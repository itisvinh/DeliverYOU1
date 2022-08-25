package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUser(String phoneNumber);
    void addUser(User user);
    List<User> getUserList();
}
