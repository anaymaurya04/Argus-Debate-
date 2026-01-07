package com.argus.core.domain;

public record DebateScore(
        int argumentScore,
        int counterScore,
        String winner
) {
}
