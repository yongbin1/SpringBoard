package com.example.demo.domain.blog.service;

import com.example.demo.domain.blog.entity.Blog;
import com.example.demo.domain.blog.facade.BlogFacade;
import com.example.demo.domain.blog.presentation.dto.request.UpdateBlogRequest;
import com.example.demo.domain.blog.repository.BlogRepository;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateBlogService {

    private final BlogFacade blogFacade;
    private final BlogRepository blogRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, UpdateBlogRequest request) {
        User user = userFacade.getCurrentLoginUser();
        Blog blog = blogFacade.findBlogById(id);

        blogFacade.checkBlogPermission(blog.getUser(), user);

        blog.updateBlog(request.getTitle(), request.getContent());
    }

}
