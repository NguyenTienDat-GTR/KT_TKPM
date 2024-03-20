/*
 * @ (#) UserService.java   1.0     08/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authenticationservice.service;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   08/03/2024
 *version: 1.0
 */

import com.example.authenticationservice.model.User;
import com.example.authenticationservice.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepositories userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        // Encode password before saving to database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
