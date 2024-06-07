package com.example.springredisopenapi.exceptions.responses;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.http.HttpStatus;

public class HttpResponse {

    private final String message;
    private final LocalDateTime timestamp;
    private final HttpStatus status;

    public HttpResponse(final String message, final HttpStatus status) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponseTO = (HttpResponse) o;
        return Objects.equals(message, httpResponseTO.message) &&
                Objects.equals(timestamp, httpResponseTO.timestamp) &&
                Objects.equals(status, httpResponseTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, timestamp, status);
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

    
}
