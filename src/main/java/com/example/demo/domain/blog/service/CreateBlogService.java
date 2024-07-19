package com.example.demo.domain.blog.service;

import com.example.demo.domain.blog.entity.Blog;
import com.example.demo.domain.blog.presentation.dto.request.CreateBlogRequest;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateBlogService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateBlogRequest request) {
        User user = userFacade.getCurrentLoginUser();
        Blog blog = request.toEntity();

        user.addBlog(blog);
    }

}
