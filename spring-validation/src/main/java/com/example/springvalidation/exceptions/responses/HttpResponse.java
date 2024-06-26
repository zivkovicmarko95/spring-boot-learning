package com.example.springvalidation.exceptions.responses;

import org.springframework.http.HttpStatus;

public record HttpResponse(
        String message,
        HttpStatus status,
        Integer statusCode
) {
    
}
