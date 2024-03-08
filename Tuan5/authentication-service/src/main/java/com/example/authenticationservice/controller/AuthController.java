/*
 * @ (#) AuthController.java   1.0     08/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authenticationservice.controller;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   08/03/2024
 *version: 1.0
 */


import com.example.authenticationservice.model.User;
import com.example.authenticationservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Assuming authentication is successful, generate JWT token
        String token = authService.generateJwtToken(user);

        return token;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        authService.registerUser(user);
        return "User registered successfully!";
    }
}

