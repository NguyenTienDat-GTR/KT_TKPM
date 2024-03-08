/*
 * @ (#) authService.java   1.0     08/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authenticationservice.service;

import com.example.authenticationservice.repositories.UserRepositories;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.authenticationservice.model.User;
import io.jsonwebtoken.Jwts;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   08/03/2024
 *version: 1.0
 */
@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpiration;
    @Autowired
    private UserRepositories userRepository;

    public AuthService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String generateJwtToken(User user){//generate token
        Date expireDate = new Date(System.currentTimeMillis() + jwtExpiration * 1000);//set expire date
        return Jwts.builder()
                .setSubject((user.getName()))
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public void registerUser(User user) {
        // Encode password before saving to database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Autowired
    private RestTemplate restTemplate;

    public void sendUserDataToDataService(User user) {
        // Tạo HttpHeaders để đặt định dạng của yêu cầu là JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Tạo HttpEntity để đặt thông tin người dùng và headers
        HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);

        // Gửi yêu cầu HTTP POST đến DataService với thông tin người dùng
        restTemplate.postForObject("http://localhost:8080/data", requestEntity, Void.class);
    }
}
