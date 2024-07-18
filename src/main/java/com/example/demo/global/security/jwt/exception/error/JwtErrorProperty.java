package com.example.demo.global.security.jwt.exception.error;

import com.example.demo.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum JwtErrorProperty implements ErrorProperty {

    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "Expired token."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid token."),
    TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "Token does not exist.");

    private final HttpStatus status;
    private final String message;

}
