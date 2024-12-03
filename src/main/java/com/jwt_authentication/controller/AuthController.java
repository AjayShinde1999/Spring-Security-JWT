package com.jwt_authentication.controller;

import com.jwt_authentication.dto.LoginDto;
import com.jwt_authentication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String login = authService.login(loginDto);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
}
