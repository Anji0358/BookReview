package com.example.bookreview.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class LoginUser extends org.springframework.security.core.userdetails.User {

    private final com.example.bookreview.entity.User user;

    public LoginUser(
            com.example.bookreview.entity.User user,
            Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

    public com.example.bookreview.entity.User getUser() {
        return user;
    }
}