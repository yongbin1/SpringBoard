package com.example.demo.domain.user.service;

import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindUserInfoService {

    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public UserResponse execute() {
        User user = userFacade.getCurrentLoginUser();

        return UserResponse.of(user);
    }

}
