/*
 * @ (#) product.java   1.0     19/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.Tuan02_apigateway.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   19/01/2024
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
    @Column(name = "productID")
    private String productID;

    @Column(name = "productName")
    private String productName;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
