package com.argus.core.api;


import com.argus.core.domain.GeneratedArgument;
import com.argus.core.domain.Stance;
import com.argus.core.generation.ArgumentGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generate")
public class ArgumentGenerationController {
    private final ArgumentGenerator argumentGenerator;

    public ArgumentGenerationController(ArgumentGenerator argumentGenerator) {
        this.argumentGenerator = argumentGenerator;
    }

    @PostMapping
    public GeneratedArgument generateArgument(@RequestParam String topic, @RequestParam Stance stance, @RequestParam int difficulty){
        return argumentGenerator.generate(topic,stance,difficulty);
    }
}
