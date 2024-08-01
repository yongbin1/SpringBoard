package com.example.demo.domain.payment.exception;

import com.example.demo.domain.payment.exception.error.PaymentErrorProperty;
import com.example.demo.global.exception.GlobalException;

public class PaymentForbiddenException extends GlobalException {

    public static final PaymentForbiddenException EXCEPTION = new PaymentForbiddenException();

    private PaymentForbiddenException() {
        super(PaymentErrorProperty.PAYMENT_FORBIDDEN);
    }
}
