package com.example.demo.domain.user.exception;

import com.example.demo.domain.user.exception.error.UserErrorProperty;
import com.example.demo.global.exception.GlobalException;

public class PasswordWrongException extends GlobalException {

    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException() {
        super(UserErrorProperty.PASSWORD_WRONG);
    }
}
