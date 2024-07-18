package com.example.demo.domain.user.exception;

import com.example.demo.domain.user.exception.error.UserErrorProperty;
import com.example.demo.global.exception.GlobalException;

public class ExistsUserIdException extends GlobalException {

    public static final ExistsUserIdException EXCEPTION = new ExistsUserIdException();

    private ExistsUserIdException() {
        super(UserErrorProperty.EXISTS_USER_ID);
    }
}
