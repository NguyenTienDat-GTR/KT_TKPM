/*
 * @ (#) Data.java   1.0     08/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.dataService.model;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   08/03/2024
 *version: 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Data")
public class Data {
    @Id
    private String id;
    private String value;
}
