package com.deliveryou.controller.util;

import com.deliveryou.pojo.Role;
import com.deliveryou.util.JSONConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class ControllerUtil {
    private ControllerUtil() {}

    public static String normalizeRole(String role) {
        if (Pattern.matches("^(role_)?(shipper|driver)$", role.toLowerCase()))
            return Role.SHIPPER;
        if (Pattern.matches("^(role_)?(admin|administrator)$", role.toLowerCase()))
            return Role.ADMIN;
        if (Pattern.matches("^(role_)?(user|regular_user)$", role.toLowerCase()))
            return Role.REGULAR_USER;
        return null;
    }

    public static ResponseEntity responseEntity(HttpStatus status) {
        return responseEntity(status, null, null);
    }

    public static ResponseEntity responseEntity(HttpStatus status, List<String> keys, List<Object> values) {
        if (keys != null && values != null) {
            if (keys.size() != values.size())
                throw new IllegalArgumentException("Keys and Values have different size");

            return new ResponseEntity(JSONConverter.convert(new HashMap<String, Object>() {{
                for (int i = 0; i < keys.size(); i++) {
                    put(keys.get(i), values.get(i));
                }
            }}), status);

        } else
            return new ResponseEntity(status);

    }

}
