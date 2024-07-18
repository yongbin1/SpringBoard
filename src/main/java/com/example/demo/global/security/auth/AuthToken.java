package com.example.demo.global.security.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthToken extends UsernamePasswordAuthenticationToken {

    public AuthToken(UserDetails userDetails) {
        super(userDetails, userDetails.getPassword(),  userDetails.getAuthorities());
    }

}
