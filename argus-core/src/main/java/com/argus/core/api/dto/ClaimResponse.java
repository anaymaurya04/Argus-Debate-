package com.argus.core.api.dto;

import java.util.List;

public record ClaimResponse(
        String text,
        double confidence,
        List<String> issues
) {}
