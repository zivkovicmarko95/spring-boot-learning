package com.example.springquartzwebclient.exceptions;

public class IdInvalidFormatException extends RuntimeException {
    
    public IdInvalidFormatException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
