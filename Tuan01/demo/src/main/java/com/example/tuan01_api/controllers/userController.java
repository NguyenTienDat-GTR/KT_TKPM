/*
 * @ (#) userController.java   1.0     12/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.tuan01_api.controllers;

import com.example.tuan01_api.models.user;
import com.example.tuan01_api.repositories.userRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   12/01/2024
 *version: 1.0
 */
@RestController
public class userController {
    @Autowired
    private userRepositories userRepo;
    @GetMapping("/users")   // get all users
    List<user> getAllUsers() {
        return userRepo.findAll();
    }
    @GetMapping("/users/{id}") // get user by id
    user getUserById(@PathVariable long id) {
        return userRepo.findById(id).get();
    }


}
