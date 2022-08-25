package com.deliveryou.exception;

import org.springframework.security.core.AuthenticationException;

public class PhoneNumberNotFoundException extends AuthenticationException {
    public PhoneNumberNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public PhoneNumberNotFoundException(String msg) {
        super(msg);
    }
}
