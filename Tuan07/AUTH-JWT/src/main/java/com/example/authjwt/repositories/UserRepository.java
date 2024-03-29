/*
 * @ (#) UserRepository.java   1.0     29/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */

package com.example.authjwt.repositories;

import com.example.authjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   29/03/2024
 *version: 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}
