package com.hobbytravelmatchmaker.hobby_travel_matchmaker_springboot_server.exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message) {
        super(message);
    }
}