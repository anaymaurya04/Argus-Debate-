package com.argus.core.api.error;

import java.util.Map;

public record ApiErrorResponse(
        String error,
        String message,
        Map<String, String> details
) {}
