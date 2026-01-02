package com.argus.core.service;

import com.argus.core.domain.AnalysisResult;
import com.argus.core.domain.Argument;
import com.argus.core.domain.Claim;
import org.springframework.stereotype.Service;
import com.argus.core.analysis.HeuristicArgumentAnalyzer;

import java.util.List;
import java.util.UUID;

@Service
public class ArgumentAnalyzerService {
    public  final HeuristicArgumentAnalyzer analyzer;
    public ArgumentAnalyzerService(HeuristicArgumentAnalyzer analyzer){

        this.analyzer = analyzer;
    }
    public AnalysisResult analyze(Argument argument){
        return analyzer.analyse(argument);
    }
}
