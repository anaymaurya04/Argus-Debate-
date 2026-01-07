package com.argus.core.generation;

import com.argus.core.domain.CounterArgument;
import com.argus.core.domain.GeneratedArgument;
import org.springframework.stereotype.Component;

@Component
public class StubCounterArgumentGenerator implements CounterArgumentGenerator {

    @Override
    public CounterArgument generateCounter(GeneratedArgument argument, int difficultyLevel) {

        String originalClaim = argument.claims().get(0);

        String response;

        if (difficultyLevel <= 1) {
            response = "This claim is too simplistic.";
        } else if (difficultyLevel <= 3) {
            response = "This claim ignores important limitations.";
        } else {
            response = "This claim assumes certain conditions but fails to consider counter-evidence.";
        }

        return new CounterArgument(originalClaim, response);
    }
}
