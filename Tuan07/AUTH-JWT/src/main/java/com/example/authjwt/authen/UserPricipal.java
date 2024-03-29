/*
 * @ (#) UserPricipal.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authjwt.authen;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */
@Getter
@Setter
public class UserPricipal implements UserDetails {
    private Long userId;
    private String username;
    private String password;
    private Collection authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
