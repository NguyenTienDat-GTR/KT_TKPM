/*
 * @ (#) User.java   1.0     29/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authjwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   29/03/2024
 *version: 1.0
 */
@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends BaseEntity{

    private String username;
    private String password;

}
