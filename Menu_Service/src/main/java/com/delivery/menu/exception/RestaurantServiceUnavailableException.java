package com.delivery.menu.exception;

public class RestaurantServiceUnavailableException extends RuntimeException {
    public RestaurantServiceUnavailableException(String message) {
        super(message);
    }
}