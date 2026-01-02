package com.argus.core.domain;

import java.util.List;
import java.util.UUID;

public record AnalysisResult(
        UUID argumentId,
        List<Claim> claims,
        String summary
) {}
