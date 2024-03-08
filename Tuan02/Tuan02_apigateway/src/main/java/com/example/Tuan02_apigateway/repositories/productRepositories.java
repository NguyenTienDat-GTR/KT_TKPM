/*
 * @ (#) productRepositories.java   1.0     19/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */

package com.example.Tuan02_apigateway.repositories;

import com.example.Tuan02_apigateway.models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   19/01/2024
 *version: 1.0
 */
@Repository
public interface productRepositories extends JpaRepository<product, String> {
}
