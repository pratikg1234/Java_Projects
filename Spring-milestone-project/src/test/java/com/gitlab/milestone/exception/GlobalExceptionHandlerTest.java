package com.gitlab.milestone.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    @DisplayName("Should handle custom exceptions")
    void handleCustomExceptions() {
        ResponseEntity<?> response = handler.handleCustomExceptions(new MilestoneTitleNotUniqueException("Not unique"));
        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(((Map<?, ?>) response.getBody()).get("error")).isEqualTo("Not unique");
    }

    @Test
    @DisplayName("Should handle generic exceptions")
    void handleOtherExceptions() {
        ResponseEntity<?> response = handler.handleOtherExceptions(new RuntimeException("fail"));
        assertThat(response.getStatusCodeValue()).isEqualTo(500);
        assertThat(((Map<?, ?>) response.getBody()).get("error")).isEqualTo("Internal server error");
    }
}