package com.example.demo.domain.payment.exception;

import com.example.demo.domain.payment.exception.error.PaymentErrorProperty;
import com.example.demo.global.exception.GlobalException;

public class PaymentNotFoundException extends GlobalException {

    public static final PaymentNotFoundException EXCEPTION = new PaymentNotFoundException();

    private PaymentNotFoundException() {
        super(PaymentErrorProperty.PAYMENT_NOT_FOUND);
    }
}
