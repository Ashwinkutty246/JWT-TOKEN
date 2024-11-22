package com.Token.JWT_Token.Dtos;

import lombok.Data;

@Data
public class RegisterUserDto {

    private String email;

    private String password;

    private String fullName;
//    private Long phone;
//    private Gender gender;
//    private Integer age;

}
