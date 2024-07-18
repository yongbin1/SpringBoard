package com.example.demo.domain.auth.presentation.dto.response;

import com.example.demo.domain.user.presentation.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserTokenResponse {

    private String accessToken;
    private String refreshToken;
    private UserResponse userData;

}
