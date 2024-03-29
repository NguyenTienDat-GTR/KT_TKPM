/*
 * @ (#) UserService.java   1.0     29/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */

package com.example.authjwt.service;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   29/03/2024
 *version: 1.0
 */

import com.example.authjwt.authen.UserPricipal;
import com.example.authjwt.entity.User;

public interface UserService {
    User createUser(User user);
    UserPricipal findByUsername(String username);
}
