package com.argus.core.domain;

public record DebateRound(
        GeneratedArgument argument,
        CounterArgument counterArgument,
        DebateScore score
) {
}
