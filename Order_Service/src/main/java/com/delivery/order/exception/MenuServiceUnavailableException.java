package com.delivery.order.exception;

public class MenuServiceUnavailableException extends RuntimeException {
    public MenuServiceUnavailableException(String message) {
        super(message);
    }
}
