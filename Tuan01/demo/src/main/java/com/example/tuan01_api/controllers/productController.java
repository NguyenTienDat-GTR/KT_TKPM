/*
 * @ (#) productController.java   1.0     12/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.tuan01_api.controllers;

import com.example.tuan01_api.models.product;
import com.example.tuan01_api.models.user;
import com.example.tuan01_api.repositories.productRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   12/01/2024
 *version: 1.0
 */
@RestController
public class productController {

    @Autowired
    private productRepositories productRepo;
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("products")
    List<product> getAllProducts() {
        for (int i = 0; i < 5; i++) {
            productRepo.save(new product(i, "product" + i));
        }   // add 5 products to database
        return productRepo.findAll();
    }

    @GetMapping("products/{id}")
    product getUserById(@PathVariable long id) {
        user user = restTemplate.getForObject("http://localhost:8080/users/" + id, user.class);
        product product = productRepo.findById(id).get();
        product.setUser(user);
        return product;
    }
}
