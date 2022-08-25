package com.deliveryou.exception;

public class UnimplementedException extends RuntimeException{
    public UnimplementedException() {
        super();
    }

    public UnimplementedException(String msg) {
        super(msg);
    }

    public UnimplementedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
