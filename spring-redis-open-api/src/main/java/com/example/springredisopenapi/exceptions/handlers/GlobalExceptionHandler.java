package com.example.springredisopenapi.exceptions.handlers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.springredisopenapi.exceptions.ResourceNotFoundException;
import com.example.springredisopenapi.exceptions.responses.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String EXTENDED_MESSAGE_FORMAT = "%s %s";
    private static final String METHOD_NOT_ALLOWED_MESSAGE = "This method is not supported. Please send a '%s' request";
    private static final String ARGUMENT_MISMATCH_MESSAGE = "Invalid request, argument type mismatch.";
    private static final String INVALID_FORMAT_MESSAGE = "Provided parameter has invalid format.";
    private static final String REQUEST_NOT_READABLE_MESSAGE = "Provided HTTP message is not readable. Please check request body.";
    private static final String INVALID_FIELDS_MESSAGE = "Validation failed. Invalid fields are:";
    private static final String RESOURCE_NOT_FOUND_MESSAGE = "Resource not found:";
    private static final String GENERAL_EXCEPTION_MESSAGE = "Server is unavailable now. Try again later.";
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<HttpResponse> methodNotSupported(final HttpRequestMethodNotSupportedException e) {

        final HttpMethod supportedHttpMethods = Objects.requireNonNull(e.getSupportedHttpMethods()).stream()
                .findAny()
                .orElseThrow();

        return new ResponseEntity<>(
                new HttpResponse(
                        String.format(METHOD_NOT_ALLOWED_MESSAGE, supportedHttpMethods), HttpStatus.METHOD_NOT_ALLOWED
                ),
                HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<HttpResponse> methodArgumentTypeMismatch(final MethodArgumentTypeMismatchException e) {

        return new ResponseEntity<>(
                new HttpResponse(
                        String.format(EXTENDED_MESSAGE_FORMAT, ARGUMENT_MISMATCH_MESSAGE, e.getMessage()),
                        HttpStatus.BAD_REQUEST
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<HttpResponse> invalidArgument(final IllegalArgumentException e) {

        return new ResponseEntity<>(
                new HttpResponse(
                        String.format(EXTENDED_MESSAGE_FORMAT, INVALID_FORMAT_MESSAGE, e.getMessage()),
                        HttpStatus.BAD_REQUEST
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HttpResponse> messageNotReadable(final HttpMessageNotReadableException e) {

        return new ResponseEntity<>(
                new HttpResponse(
                        String.format(EXTENDED_MESSAGE_FORMAT, REQUEST_NOT_READABLE_MESSAGE, e.getMessage()),
                        HttpStatus.BAD_REQUEST
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<HttpResponse> httpMediaTypeNotSupported() {

        return new ResponseEntity<>(
                new HttpResponse(REQUEST_NOT_READABLE_MESSAGE, HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponse> methodArgumentNotValid(final MethodArgumentNotValidException e) {

        return new ResponseEntity<>(
                new HttpResponse(
                        String.format(EXTENDED_MESSAGE_FORMAT, INVALID_FIELDS_MESSAGE, this.getValidationMessages(e)),
                        HttpStatus.BAD_REQUEST
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HttpResponse> validationError(final ResourceNotFoundException e) {

        return new ResponseEntity<>(
                new HttpResponse(
                        String.format(EXTENDED_MESSAGE_FORMAT, RESOURCE_NOT_FOUND_MESSAGE, e.getMessage()),
                        HttpStatus.BAD_REQUEST
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> internalServerError(final Exception e) {
        LOGGER.info("Error occurred: {}, {}", e.getMessage(), e);

        return new ResponseEntity<>(
                new HttpResponse(GENERAL_EXCEPTION_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
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
