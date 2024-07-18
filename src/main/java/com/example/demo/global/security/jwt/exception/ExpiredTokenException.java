package com.example.demo.global.security.jwt.exception;

import com.example.demo.global.exception.GlobalException;
import com.example.demo.global.security.jwt.exception.error.JwtErrorProperty;

public class ExpiredTokenException extends GlobalException {

    public static final ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(JwtErrorProperty.EXPIRED_TOKEN);
    }
}
