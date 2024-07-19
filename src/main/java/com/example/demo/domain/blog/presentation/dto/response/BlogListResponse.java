package com.example.demo.domain.blog.presentation.dto.response;

import com.example.demo.domain.blog.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BlogListResponse {

    private Integer currentPage;
    private Boolean hasMorePage;
    private List<BlogResponse> data;

    public static BlogListResponse of(Page<Blog> pages) {
        return BlogListResponse.builder()
                .currentPage(pages.getNumber() + 1)
                .hasMorePage(pages.hasNext())
                .data(
                        pages.getContent().stream()
                                .map(BlogResponse::of)
                                .toList()
                )
                .build();
    }

}
