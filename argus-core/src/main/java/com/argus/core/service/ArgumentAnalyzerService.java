package com.argus.core.service;

import com.argus.core.analysis.ArgumentAnalyzer;
import com.argus.core.domain.AnalysisResult;
import com.argus.core.domain.Argument;
import org.springframework.stereotype.Service;

@Service
public class ArgumentAnalyzerService {

    private final ArgumentAnalyzer analyzer;

    public ArgumentAnalyzerService(ArgumentAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public AnalysisResult analyze(Argument argument) {
        return analyzer.analyze(argument);
    }
}

