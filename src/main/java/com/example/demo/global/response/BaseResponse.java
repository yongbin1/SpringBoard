package com.example.demo.global.response;

public record BaseResponse<T>(Integer status, T data) {
}
