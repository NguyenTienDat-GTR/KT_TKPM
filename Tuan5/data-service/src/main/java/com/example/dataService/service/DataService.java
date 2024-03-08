/*
 * @ (#) DataService.java   1.0     08/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.dataService.service;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   08/03/2024
 *version: 1.0
 */

import com.example.dataService.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private RedisTemplate<String, Data> redisTemplate;//inject redis template

    public void saveData(Data data) {//save data
        redisTemplate.opsForValue().set(data.getId(), data);
    }

    public Data getData(String id) {//get data
        return redisTemplate.opsForValue().get(id);
    }

    public void deleteData(String id) {//delete data
        redisTemplate.delete(id);
    }
}
