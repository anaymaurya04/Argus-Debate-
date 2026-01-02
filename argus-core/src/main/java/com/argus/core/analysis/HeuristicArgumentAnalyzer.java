package com.argus.core.analysis;

import com.argus.core.domain.AnalysisResult;
import com.argus.core.domain.Argument;
import com.argus.core.domain.Claim;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class HeuristicArgumentAnalyzer {

    public AnalysisResult analyse(Argument argument){
        List<String> claimText = extractClaims(argument.text());

        List<Claim> claims = new ArrayList<>();
        for (String text:claimText){
            claims.add(analyzeClaim(text));
        }
        String summary = buildSummary(claims);
        return new AnalysisResult(
                argument.id(),
                claims,
                summary
        );
    }

    private String buildSummary(List<Claim> claims) {

        return "";
    }

    private Claim analyzeClaim(String text) {
        List<String> issues = new ArrayList<>();
        double confidence = 0.5;

        String lower = text.toLowerCase();

        if (lower.contains(" all ")
                || lower.contains(" every ")
                || lower.contains(" never ")
                || lower.startsWith("all ")
                || lower.startsWith("every ")
                || lower.startsWith("never ")
                || lower.endsWith(" all")
                || lower.endsWith(" every")
                || lower.endsWith(" never")) {

            issues.add("overgeneralization");
        }

        if (lower.contains(" years ")
                || lower.contains(" months ")
                || lower.contains(" soon ")) {

            issues.add("unsupported_timeline");
        }

        if (lower.contains(" because ")) {

            boolean hasEvidence =
                    lower.contains(" data ")
                            || lower.contains(" study ")
                            || lower.contains(" research ")
                            || lower.contains(" statistic ");

            if (!hasEvidence) {
                issues.add("weak_causality");
            }
        }


        confidence -= 0.1 * issues.size();
        if (confidence < 0.1) {
            confidence = 0.1;
        }

        return new Claim(text, confidence, issues);
    }



    private List<String> extractClaims(String text) {
        List<String> claims = new ArrayList<>();

        String normalized =text.toLowerCase();

        normalized = normalized.replace(" but ","|");
        normalized = normalized.replace(" because ","|");
        normalized = normalized.replace(" and ","|");

        String[] parts = normalized.split("\\|");

        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                claims.add(trimmed);
            }
        }

        return claims;

    }
}
