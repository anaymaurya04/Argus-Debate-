package com.argus.core.api;

import com.argus.core.debate.DebateService;
import com.argus.core.domain.DebateRound;
import com.argus.core.domain.Stance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/debate")

public class DebateController {
    private final DebateService debateService;

    public DebateController(DebateService debateService) {
        this.debateService = debateService;
    }
    @PostMapping("/round")
    public DebateRound debateRound(@RequestParam String topic,@RequestParam Stance stance,@RequestParam int difficultyLevel){
        return debateService.debateRound(topic,stance,difficultyLevel);
    }
}
