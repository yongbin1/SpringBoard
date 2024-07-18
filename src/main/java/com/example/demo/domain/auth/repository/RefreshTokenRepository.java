package com.example.demo.domain.auth.repository;

import com.example.demo.domain.auth.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
