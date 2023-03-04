package com.robertndlala.submission.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super("The Client id '" + id + "' does not exist in our records");
    }
    
}