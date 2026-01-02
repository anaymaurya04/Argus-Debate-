package com.argus.core.api.dto;

import java.util.List;
import java.util.UUID;

public record AnalysisResponse(
        UUID argumentId,
        List<ClaimResponse> claims,
        String summary
) {}
