package com.deliveryou.configuration;

import com.cloudinary.Cloudinary;
import com.deliveryou.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;

@Configuration
@Order(1)
public class AdminSecurityConfiguration {

    @Autowired
    private UserService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(new HashMap() {{
            put("cloud_name", "quocnv0707");
            put("api_key", "252896799917597");
            put("api_secret", "LhJpqRPCnCr6AxVsaSnsG7TpjtA");
            put("secure", true);
        }});
    }
}
