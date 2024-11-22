package com.Token.JWT_Token.Dtos;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;

    private String password;
}
