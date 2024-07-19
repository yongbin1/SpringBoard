package com.example.demo.domain.blog.exception.error;

import com.example.demo.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BlogErrorProperty implements ErrorProperty {

    BLOG_FORBIDDEN(HttpStatus.FORBIDDEN, "Blog permission is required."),
    BLOG_NOT_FOUND(HttpStatus.NOT_FOUND, "Blog does not exist");

    private final HttpStatus status;
    private final String message;

}
