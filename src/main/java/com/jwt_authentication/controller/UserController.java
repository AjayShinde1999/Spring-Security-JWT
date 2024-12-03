package com.jwt_authentication.controller;

import com.jwt_authentication.dto.SignUpDto;
import com.jwt_authentication.dto.UserDto;
import com.jwt_authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        UserDto userDto = userService.signUp(signUpDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}
