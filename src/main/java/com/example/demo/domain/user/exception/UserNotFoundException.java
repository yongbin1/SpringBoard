package com.example.demo.domain.user.exception;

import com.example.demo.domain.user.exception.error.UserErrorProperty;
import com.example.demo.global.exception.GlobalException;

public class UserNotFoundException extends GlobalException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
