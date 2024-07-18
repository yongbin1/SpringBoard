package com.example.demo.global.security.jwt;

import com.example.demo.domain.user.entity.User;
import com.example.demo.global.security.auth.AuthDetailsService;
import com.example.demo.global.security.auth.AuthToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;
    private final AuthDetailsService authDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String token = jwtProvider.resolveToken(request);

        if (token != null) {
            User user = jwtProvider.validateToken(token);
            setAuthentication(user.getUserId(), request);
        }

        filterChain.doFilter(request, response);
    }

    private void setAuthentication(String userId, HttpServletRequest request) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(userId);
        UsernamePasswordAuthenticationToken authentication = new AuthToken(userDetails);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
