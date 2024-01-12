/*
 * @ (#) productRepositories.java   1.0     12/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */

package com.example.tuan01_api.repositories;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   12/01/2024
 *version: 1.0
 */

import com.example.tuan01_api.models.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepositories extends JpaRepository<product, Long> {
}
