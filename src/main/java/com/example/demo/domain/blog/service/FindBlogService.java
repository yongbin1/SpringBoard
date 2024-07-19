package com.example.demo.domain.blog.service;

import com.example.demo.domain.blog.entity.Blog;
import com.example.demo.domain.blog.facade.BlogFacade;
import com.example.demo.domain.blog.presentation.dto.response.BlogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindBlogService {

    private final BlogFacade blogFacade;

    @Transactional(readOnly = true)
    public BlogResponse execute(Long id) {
        Blog blog = blogFacade.findBlogById(id);

        return BlogResponse.of(blog);
    }


}
