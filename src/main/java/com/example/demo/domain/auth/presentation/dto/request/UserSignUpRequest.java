package com.example.demo.domain.auth.presentation.dto.request;

import com.example.demo.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpRequest {

    private String userId;
    private String email;
    private String name;
    private String password;
    private String phone;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .userId(this.userId)
                .email(this.email)
                .name(this.name)
                .password(encodedPassword)
                .phone(this.phone)
                .isAdmin(false)
                .build();
    }

}
