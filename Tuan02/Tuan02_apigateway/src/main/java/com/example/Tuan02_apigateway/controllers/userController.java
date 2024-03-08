/*
 * @ (#) userController.java   1.0     19/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.Tuan02_apigateway.controllers;

import com.example.Tuan02_apigateway.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.Tuan02_apigateway.repositories.userRepositories;

import java.util.List;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   19/01/2024
 *version: 1.0
 */
@RestController
public class userController {
    @Autowired
    private userRepositories userRepositories;

    @GetMapping("/user")
    List<user> getAllUser() {
        return userRepositories.findAll();
    }

    @GetMapping("/user/{id}")
    user getUserById(@PathVariable String id) {
        return userRepositories.findById(id).get();
    }
}
