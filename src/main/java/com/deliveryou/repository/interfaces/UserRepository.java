package com.deliveryou.repository.interfaces;

import java.util.List;

public interface UserRepository {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deactivateUser(int id);
    User getUser(String phoneNumber);
    List<User> getUserList();
}
