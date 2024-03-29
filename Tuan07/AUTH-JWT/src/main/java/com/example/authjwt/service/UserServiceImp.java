/*
 * @ (#) UserServiceImp.java   1.0     29/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authjwt.service;

import com.example.authjwt.authen.UserPricipal;
import com.example.authjwt.entity.User;
import com.example.authjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   29/03/2024
 *version: 1.0
 */
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserPricipal findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserPricipal userPricipal = new UserPricipal();

        if(user != null){
            userPricipal.setUserId(user.getId());
            userPricipal.setUsername(user.getUsername());
            userPricipal.setPassword(user.getPassword());
        }
        return userPricipal;
    }
}
