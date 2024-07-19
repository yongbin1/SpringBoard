package com.example.demo.domain.blog.facade;

import com.example.demo.domain.blog.entity.Blog;
import com.example.demo.domain.blog.exception.BlogForbiddenException;
import com.example.demo.domain.blog.exception.BlogNotFoundException;
import com.example.demo.domain.blog.repository.BlogRepository;
import com.example.demo.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class BlogFacade {

    private final BlogRepository blogRepository;

    @Transactional(readOnly = true)
    public Blog findBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> BlogNotFoundException.EXCEPTION);
    }

    @Transactional(readOnly = true)
    public void checkBlogPermission(User author, User loginUser) {
        if (!author.equals(loginUser)) {
            throw BlogForbiddenException.EXCEPTION;
        }
    }

    @Transactional(readOnly = true)
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

}
