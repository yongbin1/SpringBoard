package com.example.demo.global.security;

import com.example.demo.global.security.auth.AuthDetailsService;
import com.example.demo.global.security.jwt.JwtFilter;
import com.example.demo.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtProvider jwtProvider;
    private final AuthDetailsService authDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web ->
                web.ignoring().requestMatchers(
                        "/swagger-ui/**",
                        "/configuration/**",
                        "/swagger-resources/**",
                        "/v3/api-docs/**",
                        "/webjars/**",
                        "/webjars/springfox-swagger-ui/*.{js,css}",
                        "/bus/v3/api-docs/**"
                );
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                        // Custom AuthorizeHttpRequest Matcher (hasRole)
                        .requestMatchers(HttpMethod.POST, "").hasRole("USER")

                        // Custom AuthorizeHttpRequest Matcher (hasAnyRole)
                        .requestMatchers(HttpMethod.POST, "").hasAnyRole("USER", "ADMIN")

                        // Custom AuthorizeHttpRequest Matcher (authenticated)
                        .requestMatchers(HttpMethod.POST, "").authenticated()

                        .anyRequest().denyAll()
                )
                .addFilterBefore(new JwtFilter(jwtProvider, authDetailsService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
