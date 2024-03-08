/*
 * @ (#) productController.java   1.0     19/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.Tuan02_apigateway.controllers;

import com.example.Tuan02_apigateway.models.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.Tuan02_apigateway.repositories.productRepositories;

import java.util.List;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   19/01/2024
 *version: 1.0
 */
@RestController
public class productController {

    @Autowired
    private productRepositories productRepositories;

    @GetMapping("/product")
    List<product> getAllProduct() {
        return productRepositories.findAll();
    }

    @GetMapping("/product/{id}")
    product getProductById(@PathVariable String id) {
        return productRepositories.findById(id).get();
    }
}
