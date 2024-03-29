/*
 * @ (#) TokenRepository.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authjwt.repositories;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */

import com.example.authjwt.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
