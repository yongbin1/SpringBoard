package com.example.demo.global.security.jwt.exception;

import com.example.demo.global.exception.GlobalException;
import com.example.demo.global.security.jwt.exception.error.JwtErrorProperty;

public class InvalidTokenException extends GlobalException {

    public static final InvalidTokenException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(JwtErrorProperty.INVALID_TOKEN);
    }

}
