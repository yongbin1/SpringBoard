package com.example.demo.global.security.jwt.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {

    private String key;
    private String header;
    private String prefix;
    private Long accessExp;
    private Long refreshExp;

}
