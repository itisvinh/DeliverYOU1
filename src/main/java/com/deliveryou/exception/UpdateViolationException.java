package com.deliveryou.exception;

public class UpdateViolationException extends RuntimeException{
    public UpdateViolationException() {
        super();
    }

    public UpdateViolationException(String msg) {
        super(msg);
    }

    public UpdateViolationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
