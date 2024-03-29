/*
 * @ (#) TokenServiceImp.java   1.0     28/03/2024
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
import com.example.authjwt.repositories.TokenRepository;
import com.example.authjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImp implements TokenService{
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Token createToken(Token token) {
        return null;
    }

    @Override
    public Token findByToken(String token) {
        return null;
    }
}
