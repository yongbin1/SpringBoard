package com.example.demo.domain.user.presentation;

import com.example.demo.domain.user.presentation.dto.response.UserResponse;
import com.example.demo.domain.user.service.FindUserInfoService;
import com.example.demo.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final FindUserInfoService findUserInfoService;

    @GetMapping("/info")
    public BaseResponse<UserResponse> findUserInfo() {
        UserResponse response = findUserInfoService.execute();
        return new BaseResponse<>(HttpStatus.OK.value(), response);
    }

}
