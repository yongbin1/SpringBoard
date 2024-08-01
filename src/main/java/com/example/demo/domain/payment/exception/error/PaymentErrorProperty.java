package com.example.demo.domain.payment.exception.error;

import com.example.demo.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PaymentErrorProperty implements ErrorProperty {

    PAYMENT_FORBIDDEN(HttpStatus.FORBIDDEN, "Payment permission is required."),
    PAYMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Payment does not exist");

    private final HttpStatus status;
    private final String message;

}
