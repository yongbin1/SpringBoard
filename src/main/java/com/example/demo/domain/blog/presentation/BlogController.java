package com.example.demo.domain.blog.presentation;

import com.example.demo.domain.blog.presentation.dto.request.CreateBlogRequest;
import com.example.demo.domain.blog.presentation.dto.request.UpdateBlogRequest;
import com.example.demo.domain.blog.presentation.dto.response.BlogListResponse;
import com.example.demo.domain.blog.presentation.dto.response.BlogResponse;
import com.example.demo.domain.blog.service.CreateBlogService;
import com.example.demo.domain.blog.service.FindAllBlogService;
import com.example.demo.domain.blog.service.FindBlogService;
import com.example.demo.domain.blog.service.UpdateBlogService;
import com.example.demo.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/blog")
public class BlogController {

    private final CreateBlogService createBlogService;
    private final UpdateBlogService updateBlogService;

    private final FindBlogService findBlogService;
    private final FindAllBlogService findAllBlogService;

    @PostMapping("/create")
    public BaseResponse<Void> createBlog(
            @RequestBody CreateBlogRequest request
    ) {
        createBlogService.execute(request);
        return new BaseResponse<>(HttpStatus.CREATED.value(), null);
    }

    @PatchMapping("/update/{id}")
    public BaseResponse<Void> updateBlog(
            @PathVariable("id") Long id,
            @RequestBody UpdateBlogRequest request
    ) {
        updateBlogService.execute(id, request);
        return new BaseResponse<>(HttpStatus.OK.value(), null);
    }

    @GetMapping("/find/{id}")
    public BaseResponse<BlogResponse> findBlog(
            @PathVariable("id") Long id
    ) {
        BlogResponse response = findBlogService.execute(id);
        return new BaseResponse<>(HttpStatus.OK.value(), response);
    }

    @GetMapping("/find-all")
    public BaseResponse<BlogListResponse> findBlog(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        BlogListResponse response = findAllBlogService.execute(page, size);
        return new BaseResponse<>(HttpStatus.OK.value(), response);
    }

}
