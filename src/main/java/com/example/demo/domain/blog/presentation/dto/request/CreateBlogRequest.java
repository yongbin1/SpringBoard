package com.example.demo.domain.blog.presentation.dto.request;

import com.example.demo.domain.blog.entity.Blog;
import com.example.demo.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateBlogRequest {

    private String title;
    private String content;

    public Blog toEntity(User user) {
        return Blog.builder()
                .title(this.title)
                .content(this.content)
                .user(user)
                .status(false)
                .build();
    }

}
