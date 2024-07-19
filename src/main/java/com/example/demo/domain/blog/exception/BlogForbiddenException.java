package com.example.demo.domain.blog.exception;

import com.example.demo.domain.blog.exception.error.BlogErrorProperty;
import com.example.demo.global.exception.GlobalException;

public class BlogForbiddenException extends GlobalException {

    public static final BlogForbiddenException EXCEPTION = new BlogForbiddenException();

    private BlogForbiddenException() {
        super(BlogErrorProperty.BLOG_FORBIDDEN);
    }
}
