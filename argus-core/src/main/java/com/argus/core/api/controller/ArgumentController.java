package com.argus.core.api.controller;

import com.argus.core.api.dto.AnalyzeArgumentRequest;
import com.argus.core.api.dto.AnalysisResponse;
import com.argus.core.api.dto.ClaimResponse;
import com.argus.core.domain.AnalysisResult;
import com.argus.core.domain.Argument;
import com.argus.core.service.ArgumentAnalyzerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/arguments")
public class ArgumentController {

    private final ArgumentAnalyzerService analyzerService;

    public ArgumentController(ArgumentAnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
    }

    @PostMapping("/analyze")
    public AnalysisResponse analyze(
            @Valid @RequestBody AnalyzeArgumentRequest request
    ) {
        // DTO → Domain
        Argument argument = new Argument(
                UUID.randomUUID(),
                request.text()
        );

        AnalysisResult result = analyzerService.analyze(argument);

        // Domain → DTO
        List<ClaimResponse> claims = result.claims().stream()
                .map(c -> new ClaimResponse(
                        c.text(),
                        c.confidence(),
                        c.issues()
                ))
                .toList();

        return new AnalysisResponse(
                result.argumentId(),
                claims,
                result.summary()
        );
    }
}
