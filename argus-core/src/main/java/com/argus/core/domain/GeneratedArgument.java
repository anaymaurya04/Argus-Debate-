package com.argus.core.domain;

import java.util.List;

public record GeneratedArgument(
        String topic,
        Stance stance,
        int difficultyLevel,
        String openingStatement,
        List<String> claims
) {

}
