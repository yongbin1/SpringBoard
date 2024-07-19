package com.example.demo.domain.blog.presentation.dto.response;

import com.example.demo.domain.blog.entity.Blog;
import com.example.demo.domain.user.presentation.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@Builder
@AllArgsConstructor
public class BlogResponse {

    private Long id;
    private String title;
    private String content;
    private UserResponse userData;
    private String createdDateTime;
    private String updatedDateTime;

    public static BlogResponse of(Blog blog) {
        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .userData(UserResponse.of(blog.getUser()))
                .createdDateTime(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                .format(blog.getCreatedDateTime())
                )
                .updatedDateTime(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                .format(blog.getUser().getModifiedDateTime())
                )
                .build();
    }


}
