package com.example.springquartzwebclient.client.responses;
import java.util.Objects;

public class AuthResponse {

    private String token;

    public AuthResponse() {
    }

    public AuthResponse(final String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public AuthResponse token(final String token) {
        setToken(token);
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AuthResponse)) {
            return false;
        }
        AuthResponse authResponse = (AuthResponse) o;
        return Objects.equals(token, authResponse.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        return "{" +
            " token='" + getToken() + "'" +
            "}";
    }    
    
}
