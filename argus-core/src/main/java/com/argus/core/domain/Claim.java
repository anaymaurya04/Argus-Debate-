package com.argus.core.domain;

import java.util.List;

public record Claim(
        String text,
        double confidence,
        List<String> issues
) {}
