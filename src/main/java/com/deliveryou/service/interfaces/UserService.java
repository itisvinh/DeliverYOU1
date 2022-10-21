package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.DriverRegistration;
import com.deliveryou.pojo.Role;
import com.deliveryou.pojo.User;
import com.deliveryou.pojo.auxiliary.RegistrationFilter;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUser(String phoneNumber);

    User getUser(int id);
    boolean addUser(User user);
    List<User> getUserList();

    boolean updateUser(User user);

    int getIdByPhoneNumber(String phone);

    List<User> getUsersWithinRange(String role_name, int start, int end);

    boolean createDriverRegistration(DriverRegistration registration);

    List<DriverRegistration> getDriverRegistrations(RegistrationFilter filter);
}
