/*
 * @ (#) DataController.java   1.0     08/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.dataService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   08/03/2024
 *version: 1.0
 */
@RequestMapping("/data")
@RestController
public class DataController {

    @Autowired
    private AuthService authService;

    @GetMapping("/{id}")
    public String getDataFromAuthService(@PathVariable String id) {
        // Gửi yêu cầu để lấy dữ liệu từ AuthService
        String data = authService.getDataById(id);
        return data;
    }
}
