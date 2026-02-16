package com.gitlab.milestone.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import static org.assertj.core.api.Assertions.*;

class CorrelationIdUtilTest {

    @Test
    @DisplayName("Should set and get correlation id")
    void setAndGetCorrelationId() {
        CorrelationIdUtil.setCorrelationId();
        String id = CorrelationIdUtil.getCorrelationId();
        assertThat(id).isNotNull();
        assertThat(id).hasSizeGreaterThan(0);
        // Clean up
        MDC.clear();
    }
}