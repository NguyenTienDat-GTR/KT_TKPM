/*
 * @ (#) RestTemplateConfig.java   1.0     29/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   29/03/2024
 *version: 1.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
