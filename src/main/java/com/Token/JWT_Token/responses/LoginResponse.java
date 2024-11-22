package com.Token.JWT_Token.responses;


import lombok.Getter;


@Getter
public class LoginResponse {
    private String token;

    private long expiresIn;

    public void setToken(String token) {
        this.token=token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}