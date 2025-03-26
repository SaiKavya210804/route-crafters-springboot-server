package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
