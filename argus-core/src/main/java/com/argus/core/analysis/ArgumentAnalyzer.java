package com.argus.core.analysis;

import com.argus.core.domain.AnalysisResult;
import com.argus.core.domain.Argument;


public interface ArgumentAnalyzer {
    AnalysisResult analyze(Argument argument);
}
