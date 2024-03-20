/*
 * @ (#) user.java   1.0     08/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authenticationservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   08/03/2024
 *version: 1.0
 */
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_password")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
