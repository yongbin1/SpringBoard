package com.example.demo.global.security.jwt;

import com.example.demo.domain.auth.entity.RefreshToken;
import com.example.demo.domain.auth.repository.RefreshTokenRepository;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.exception.UserNotFoundException;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.global.security.jwt.exception.ExpiredTokenException;
import com.example.demo.global.security.jwt.exception.InvalidTokenException;
import com.example.demo.global.security.jwt.property.JwtProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperty property;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(String userId) {
        return generateToken(userId, property.getAccessExp());
    }

    public String generateRefreshToken(String userId) {
        String refreshToken = generateToken(userId, property.getRefreshExp());
        refreshTokenRepository.save(new RefreshToken(refreshToken, userId));

        return refreshToken;
    }

    public User validateToken(String token) {
        return userRepository.findByUserId(getTokenSubject(token))
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public String resolveToken(HttpServletRequest request) {
        return parseToken(request.getHeader(property.getHeader()));
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(getSigningKey(property.getKey()))
                    .build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private String parseToken(String bearerToken) {
        if(bearerToken != null && bearerToken.startsWith(property.getPrefix())) {
            return bearerToken.replace(property.getPrefix(), "");
        }
        return null;
    }

    private Key getSigningKey(String secretKey) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private String generateToken(String id, Long exp) {
        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .signWith(getSigningKey(property.getKey()), SignatureAlgorithm.HS256)
                .compact();
    }

}
