package com.example.demo.domain.blog.service;

import com.example.demo.domain.blog.entity.Blog;
import com.example.demo.domain.blog.facade.BlogFacade;
import com.example.demo.domain.blog.presentation.dto.response.BlogListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindAllBlogService {

    private final BlogFacade blogFacade;

    @Transactional(readOnly = true)
    public BlogListResponse execute(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "modifiedDateTime");

        Page<Blog> pages = blogFacade.findAllBlog(pageable);
        return BlogListResponse.of(pages);
    }

}
