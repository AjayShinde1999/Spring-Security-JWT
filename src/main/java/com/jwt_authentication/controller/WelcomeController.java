package com.jwt_authentication.controller;

import com.jwt_authentication.entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/welcome")
public class WelcomeController {

    @GetMapping
//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    public String welcome(@AuthenticationPrincipal User user) {
        System.out.println(user.getEmail());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user1 = (User) authentication.getPrincipal();
        System.out.println(user1.getEmail() + " : " + user1.getName() + " : "+user1.getRole());
        return "Ajay Shinde";
    }
}
