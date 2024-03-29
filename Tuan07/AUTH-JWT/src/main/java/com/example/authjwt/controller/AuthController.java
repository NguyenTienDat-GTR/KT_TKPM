/*
 * @ (#) UserController.java   1.0     29/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authjwt.controller;

import com.example.authjwt.authen.UserPricipal;
import com.example.authjwt.entity.Token;
import com.example.authjwt.entity.User;
import com.example.authjwt.service.TokenService;
import com.example.authjwt.service.UserService;
import com.example.authjwt.util.JwtUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   29/03/2024
 *version: 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public User userRegister(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
        UserPricipal userPricipal = userService.findByUsername(user.getUsername());

        if(user == null || !new BCryptPasswordEncoder().matches(user.getPassword(), userPricipal.getPassword())) {
            return ResponseEntity.badRequest().body("Username or password is incorrect");
        }

        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPricipal));

        token.setExpiryDate(jwtUtil.generateExpirationTime());

        token.setCreatedBy(userPricipal.getUserId());

        tokenService.createToken(token);

        session.setAttribute("token",token.getToken());

        return ResponseEntity.ok(token.getToken());
    }
}
