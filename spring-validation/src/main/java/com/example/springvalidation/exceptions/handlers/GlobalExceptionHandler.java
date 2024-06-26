package com.example.springvalidation.exceptions.handlers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.springvalidation.exceptions.responses.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String EXTENDED_MESSAGE_FORMAT = "%s %s";
    private static final String INVALID_FIELDS_MESSAGE = "Validation failed. Invalid fields are:";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponse> methodArgumentTypeMismatch(final MethodArgumentNotValidException e) {

        return new ResponseEntity<>(
                new HttpResponse(
                        String.format(EXTENDED_MESSAGE_FORMAT, INVALID_FIELDS_MESSAGE, this.getValidationMessages(e)),
                        HttpStatus.BAD_REQUEST,
                        e.getStatusCode().value()
                ),
                HttpStatus.BAD_REQUEST);
    }

    /**
     * Get validation message from {@link MethodArgumentNotValidException}
     * 
     * @param e Exception to be processed
     * @return {@link List} of fields that are not valid
     */
    public List<String> getValidationMessages(final MethodArgumentNotValidException e) {

        return e.getBindingResult().getAllErrors().stream()
                .map(error -> {
                    final String fieldName = ((FieldError) error).getField();
                    final String errorMessage = error.getDefaultMessage();

                    return String.format(EXTENDED_MESSAGE_FORMAT, fieldName, errorMessage);
                })
                .collect(Collectors.toList());
    }

}
