package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.User;

import java.util.List;

public interface UserRepository {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deactivateUser(int id);
    User getUser(String phoneNumber);
    User getUser(int id);
    List<User> getUserList();
}
