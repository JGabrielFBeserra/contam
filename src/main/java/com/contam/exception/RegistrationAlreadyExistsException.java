package com.contam.exception;

public class RegistrationAlreadyExistsException extends RuntimeException {
    public RegistrationAlreadyExistsException(String message) {
        super(message);
    }
}
