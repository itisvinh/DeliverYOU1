package com.deliveryou.service.implementations;

import com.deliveryou.pojo.User;
import com.deliveryou.repository.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements com.deliveryou.service.interfaces.UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String phoneNumber) {
        return phoneNumber.equalsIgnoreCase("11111") ?
                new User() {{
                    setId(1);
                    setFirstName("heilen");
                    setLastName("carls");
                    setPassword("1234567890");
                    setEmail("he@gmail.com");
                    setRole("ROLE_USER");
                }} : null;
    }
}
