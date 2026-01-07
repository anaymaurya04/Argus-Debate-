package com.argus.core.generation;

import com.argus.core.domain.CounterArgument;
import com.argus.core.domain.GeneratedArgument;

public interface CounterArgumentGenerator {
    CounterArgument generateCounter (
            GeneratedArgument argument,
            int difficultyLevel
    );
}
