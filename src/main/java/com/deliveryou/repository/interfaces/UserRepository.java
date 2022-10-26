package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.DriverRegistration;
import com.deliveryou.pojo.Role;
import com.deliveryou.pojo.User;
import com.deliveryou.pojo.auxiliary.RegistrationFilter;

import java.util.List;

public interface UserRepository {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deactivateUser(int id);
    User getUser(String phoneNumber);
    User getUser(int id);
    List<User> getUserList();

    int getIdByPhone(String phone);

    List<User> getUsersWithinRange(String role_name, int start, int end);

    boolean createDriverRegistration(DriverRegistration registration);

    List<DriverRegistration> getDriverRegistrations(RegistrationFilter filter);

    boolean processDriverRegistration(DriverRegistration registration);

    DriverRegistration getDriverRegistration(int id);
}
