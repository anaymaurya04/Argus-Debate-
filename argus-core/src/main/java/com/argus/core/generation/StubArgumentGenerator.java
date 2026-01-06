package com.argus.core.generation;

import com.argus.core.domain.GeneratedArgument;
import com.argus.core.domain.Stance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StubArgumentGenerator implements ArgumentGenerator {

    @Override
    public GeneratedArgument generate(String topic, Stance stance, int difficultyLevel) {

        String openingStatement;

        if (stance == Stance.FOR) {
            openingStatement = "This argument supports the position that " + topic + ".";
        } else {
            openingStatement = "This argument opposes the position that " + topic + ".";
        }

        List<String> claims = List.of(
                "This is a basic supporting claim.",
                "This claim reflects the chosen stance.",
                "At higher difficulty levels, this would be more sophisticated."
        );

        return new GeneratedArgument(
                topic,
                stance,
                difficultyLevel,
                openingStatement,
                claims
        );
    }
}
