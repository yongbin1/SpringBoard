package com.example.demo.domain.user.exception;

import com.example.demo.domain.user.exception.error.UserErrorProperty;
import com.example.demo.global.exception.GlobalException;

public class ExistsUserEmailException extends GlobalException {

    public static final ExistsUserEmailException EXCEPTION = new ExistsUserEmailException();

    private ExistsUserEmailException() {
        super(UserErrorProperty.EXISTS_USER_EMAIL);
    }
}
