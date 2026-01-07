package com.argus.core.debate;

import com.argus.core.domain.DebateRound;
import com.argus.core.domain.GeneratedArgument;
import com.argus.core.domain.Stance;
import com.argus.core.generation.ArgumentGenerator;
import com.argus.core.generation.CounterArgumentGenerator;
import org.springframework.stereotype.Service;

@Service
public class DebateService {

    private final ArgumentGenerator argumentGenerator;
    private final CounterArgumentGenerator counterArgumentGenerator;

    public DebateService(
            ArgumentGenerator argumentGenerator,
            CounterArgumentGenerator counterArgumentGenerator
    ) {
        this.argumentGenerator = argumentGenerator;
        this.counterArgumentGenerator = counterArgumentGenerator;
    }

    public DebateRound debateRound(String topic, Stance stance, int difficultyLevel) {

        GeneratedArgument argument =
                argumentGenerator.generate(topic, stance, difficultyLevel);

        var counterArgument =
                counterArgumentGenerator.generateCounter(argument, difficultyLevel);

        return new DebateRound(argument, counterArgument);
    }
}
