package com.argus.core.analysis;

import com.argus.core.domain.AnalysisResult;
import com.argus.core.domain.Argument;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CompositeArgumentAnalyzer implements ArgumentAnalyzer{

    private final HeuristicArgumentAnalyzer heuristicArgumentAnalyzer;

    public CompositeArgumentAnalyzer(HeuristicArgumentAnalyzer heuristicArgumentAnalyzer) {
        this.heuristicArgumentAnalyzer = heuristicArgumentAnalyzer;
    }

    @Override
    public AnalysisResult analyze(Argument argument) {
        return heuristicArgumentAnalyzer .analyze(argument);
    }
}
