package com.example.demo.global.exception;

import com.example.demo.global.response.GlobalErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GlobalException.class})
    public ResponseEntity<GlobalErrorResponse> handleException(GlobalException ex) {
        GlobalErrorResponse response = GlobalErrorResponse.builder()
                .status(ex.getError().getStatus().value())
                .message(ex.getError().getMessage())
                .build();
        return new ResponseEntity<>(response, ex.getError().getStatus());
    }

}
