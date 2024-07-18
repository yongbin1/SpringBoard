package com.example.demo.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSignInRequest {

    private String userId;
    private String password;

}
