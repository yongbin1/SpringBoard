package com.example.demo.domain.blog.repository;

import com.example.demo.domain.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
