/*
 * @ (#) Token.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authjwt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */
@Entity
@Table(name = "token")
@Getter
@Setter
public class Token extends BaseEntity {

    @Column(length = 1000)
    private String token;

    private Date expiryDate;

}
