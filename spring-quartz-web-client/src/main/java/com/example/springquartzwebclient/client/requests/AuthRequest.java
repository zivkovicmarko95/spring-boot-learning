package com.example.springquartzwebclient.client.requests;
import java.util.Objects;

public class AuthRequest {

    private String username;
    private String password;

    public AuthRequest(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public AuthRequest username(final String username) {
        setUsername(username);
        return this;
    }

    public AuthRequest password(final String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AuthRequest)) {
            return false;
        }
        AuthRequest authRequest = (AuthRequest) o;
        return Objects.equals(username, authRequest.username) &&
                Objects.equals(password, authRequest.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }    
    
}
