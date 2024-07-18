package com.example.demo.domain.auth.service;

import com.example.demo.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.demo.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.presentation.dto.response.UserResponse;
import com.example.demo.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignInService {

    private final UserFacade userFacade;
    private final JwtProvider jwtProvider;

    @Transactional
    public UserTokenResponse execute(UserSignInRequest request) {
        userFacade.checkExistsId(request.getUserId());

        User user = userFacade.findUserById(request.getUserId());
        userFacade.checkPasswordMatch(request.getPassword(), user.getPassword());

        return UserTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(user.getUserId()))
                .refreshToken(jwtProvider.generateRefreshToken(user.getUserId()))
                .userData(UserResponse.of(user))
                .build();
    }

}
