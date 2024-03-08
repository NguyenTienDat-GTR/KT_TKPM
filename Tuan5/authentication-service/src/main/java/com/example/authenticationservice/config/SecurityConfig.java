/*
 * @ (#) SecurityConfig.java   1.0     08/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authenticationservice.config;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   08/03/2024
 *version: 1.0
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
