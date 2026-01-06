package com.argus.core.generation;

import com.argus.core.domain.GeneratedArgument;
import com.argus.core.domain.Stance;

public interface ArgumentGenerator {

    GeneratedArgument generate(
            String topic,
            Stance stance,
            int difficultyLevel
    );
}
