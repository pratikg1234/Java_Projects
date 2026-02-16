package com.gitlab.milestone.security;

import com.gitlab.milestone.config.AppProperties;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;

class JwtTokenProviderTest {

    private JwtTokenProvider jwtTokenProvider;

    @BeforeEach
    void setUp() {
        AppProperties appProperties = new AppProperties();
        appProperties.setJwtSecret("mySecretKey");
        appProperties.setJwtExpirationMs(3600000L);
        jwtTokenProvider = new JwtTokenProvider();
        jwtTokenProvider.appProperties = appProperties;
    }

    @Test
    @DisplayName("Should generate and validate token")
    void generateAndValidateToken() {
        Authentication auth = new UsernamePasswordAuthenticationToken("testuser", null);
        String token = jwtTokenProvider.generateToken(auth);

        assertThat(jwtTokenProvider.validateToken(token)).isTrue();
        assertThat(jwtTokenProvider.getUsernameFromJWT(token)).isEqualTo("testuser");
    }

    @Test
    @DisplayName("Should return false for invalid token")
    void validateToken_invalid() {
        assertThat(jwtTokenProvider.validateToken("invalid.token")).isFalse();
    }
}