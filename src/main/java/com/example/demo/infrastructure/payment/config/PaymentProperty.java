package com.example.demo.infrastructure.payment.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "payment")
public class PaymentProperty {

    private String clientId;
    private String secretKey;

}
