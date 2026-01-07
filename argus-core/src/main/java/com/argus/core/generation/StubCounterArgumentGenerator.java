package com.argus.core.generation;


import com.argus.core.domain.CounterArgument;
import com.argus.core.domain.GeneratedArgument;
import org.springframework.stereotype.Component;

@Component
public class StubCounterArgumentGenerator implements CounterArgumentGenerator{

    @Override
    public CounterArgument generateCounter(GeneratedArgument argument, int difficultyLevel) {

        return null;
    }
}
