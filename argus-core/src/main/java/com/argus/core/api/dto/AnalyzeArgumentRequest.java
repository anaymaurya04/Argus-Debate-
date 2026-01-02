package com.argus.core.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AnalyzeArgumentRequest(
        @NotBlank(message = "Argument should not be empty")
        String text
) {

}
