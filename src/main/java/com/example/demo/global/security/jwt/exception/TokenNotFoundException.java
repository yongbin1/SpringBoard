package com.example.demo.global.security.jwt.exception;

import com.example.demo.global.exception.GlobalException;
import com.example.demo.global.security.jwt.exception.error.JwtErrorProperty;

public class TokenNotFoundException extends GlobalException {

    private static final TokenNotFoundException EXCEPTION = new TokenNotFoundException();

    private TokenNotFoundException() {
        super(JwtErrorProperty.TOKEN_NOT_FOUND);
    }
}
