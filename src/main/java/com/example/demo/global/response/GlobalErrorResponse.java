package com.example.demo.global.response;

import lombok.Builder;

@Builder
public record GlobalErrorResponse(int status, String message) {
}
