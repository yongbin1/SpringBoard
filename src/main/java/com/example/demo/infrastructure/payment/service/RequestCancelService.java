package com.example.demo.infrastructure.payment.service;

import com.example.demo.domain.payment.repository.PaymentRepository;
import com.example.demo.infrastructure.payment.config.PaymentProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestCancelService {

    private final PaymentRepository paymentRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PaymentProperty paymentProperty;

    @Transactional
    public String execute(String tid, String amount) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString((paymentProperty.getClientId() + ":" + paymentProperty.getSecretKey()).getBytes()));
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> AuthenticationMap = new HashMap<>();
        AuthenticationMap.put("amount", amount);
        AuthenticationMap.put("reason", "test");
        AuthenticationMap.put("orderId", UUID.randomUUID().toString());

        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(AuthenticationMap), headers);

        ResponseEntity<JsonNode> responseEntity = restTemplate.postForEntity(
                "https://sandbox-api.nicepay.co.kr/v1/payments/"+ tid +"/cancel", request, JsonNode.class);

        JsonNode responseNode = responseEntity.getBody();
        String resultCode = responseNode.get("resultCode").asText();

        if (resultCode.equalsIgnoreCase("0000")) {
            // 취소 성공 비즈니스 로직 구현
        } else {
            // 취소 실패 비즈니스 로직 구현
        }

        return responseNode.get("resultMsg").asText();
    }

}
