package com.jwt_authentication.dto;

import lombok.Data;

@Data
public class LoginDto {

    private String email;
    private String password;
}
