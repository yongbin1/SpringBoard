package com.example.demo.domain.auth.presentation;

import com.example.demo.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.demo.domain.auth.presentation.dto.request.UserSignUpRequest;
import com.example.demo.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.demo.domain.auth.service.UserSignInService;
import com.example.demo.domain.auth.service.UserSignUpService;
import com.example.demo.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;

    @PostMapping("/sign-up")
    public BaseResponse<Void> userSignUp(
            @RequestBody UserSignUpRequest request
    ) {
        userSignUpService.execute(request);
        return new BaseResponse<>(HttpStatus.CREATED.value(), null);
    }

    @PostMapping("/sign-in")
    public BaseResponse<UserTokenResponse> userSignIn(
            @RequestBody UserSignInRequest request
    ) {
        UserTokenResponse response = userSignInService.execute(request);
        return new BaseResponse<>(HttpStatus.OK.value(), response);
    }

}
