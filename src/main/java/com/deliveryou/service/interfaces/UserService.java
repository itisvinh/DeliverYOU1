package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUser(String phoneNumber);

    User getUser(int id);
    int addUser(User user);
    List<User> getUserList();

    boolean updateUser(User user);
}
