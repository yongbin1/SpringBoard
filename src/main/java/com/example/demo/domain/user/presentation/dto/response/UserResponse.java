package com.example.demo.domain.user.presentation.dto.response;

import com.example.demo.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String userId;
    private String email;
    private String name;
    private String phone;
    private boolean isAdmin;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .phone(user.getPhone())
                .isAdmin(user.isAdmin())
                .build();
    }

}
