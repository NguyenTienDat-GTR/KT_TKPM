/*
 * @ (#) product.java   1.0     12/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.tuan01_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   12/01/2024
 *version: 1.0
 */
@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private long productId;
    @Column(name = "productName")
    private String productName;
    @OneToOne
    private user user;

    public product(long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}
