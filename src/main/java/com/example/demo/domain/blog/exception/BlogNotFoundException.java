package com.example.demo.domain.blog.exception;

import com.example.demo.domain.blog.exception.error.BlogErrorProperty;
import com.example.demo.global.exception.GlobalException;

public class BlogNotFoundException extends GlobalException {

    public static final BlogNotFoundException EXCEPTION = new BlogNotFoundException();

    private BlogNotFoundException() {
        super(BlogErrorProperty.BLOG_NOT_FOUND);
    }
}
