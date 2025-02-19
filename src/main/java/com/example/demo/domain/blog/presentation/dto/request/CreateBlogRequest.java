package com.example.demo.domain.blog.presentation.dto.request;

import com.example.demo.domain.blog.entity.Blog;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateBlogRequest {

    private String title;
    private String content;

    public Blog toEntity() {
        return Blog.builder()
                .title(this.title)
                .content(this.content)
                .status(false)
                .build();
    }

}
