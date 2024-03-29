/*
 * @ (#) TokenService.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authjwt.service;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */

import com.example.authjwt.entity.Token;
import org.springframework.stereotype.Service;


public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}
