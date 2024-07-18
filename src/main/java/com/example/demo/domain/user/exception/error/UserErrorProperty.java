package com.example.demo.domain.user.exception.error;

import com.example.demo.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorProperty implements ErrorProperty {

    EXISTS_USER_EMAIL(HttpStatus.CONFLICT, "Email already exists."),
    EXISTS_USER_ID(HttpStatus.CONFLICT, "ID already exists."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User does not exist"),
    PASSWORD_WRONG(HttpStatus.BAD_REQUEST, "Password doesn't match.");

    private final HttpStatus status;
    private final String message;

}
