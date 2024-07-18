package com.example.demo.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorCode implements ErrorProperty {

    GLOBAL_BAD_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request."),
    GLOBAL_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Authentication is required."),
    GLOBAL_FORBIDDEN(HttpStatus.FORBIDDEN, "Permission is required."),
    GLOBAL_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found."),
    GLOBAL_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred on the server.");

    private final HttpStatus status;
    private final String message;

}
