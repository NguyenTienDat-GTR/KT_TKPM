/*
 * @ (#) user.java   1.0     19/01/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.Tuan02_apigateway.models;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   19/01/2024
 *version: 1.0
 */


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class user {
    @Id
    @Column(name = "userID")
    private String userID;

    @Column(name = "userName")
    private String userName;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
