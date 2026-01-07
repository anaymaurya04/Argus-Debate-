package com.argus.core.generation;

import com.argus.core.domain.GeneratedArgument;
import com.argus.core.domain.Stance;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StubArgumentGenerator implements ArgumentGenerator {

    @Override
    public GeneratedArgument generate(String topic, Stance stance, int difficultyLevel) {

        String openingStatement;

        if (stance == Stance.FOR) {
            openingStatement = "This argument supports the position that " + topic + ".";
        } else {
            openingStatement = "This argument opposes the position that " + topic + ".";
        }
        List<String> claims = new ArrayList<>();

        if (difficultyLevel == 1){
            claims.add("This is obviously true");
        } else if (difficultyLevel <=3&& difficultyLevel>1) {
            claims.add("This has the data proving the point clearly");
        }
        else{
            claims.add("While there are limitations, evidence suggests…");
        }


        return new GeneratedArgument(
                topic,
                stance,
                difficultyLevel,
                openingStatement,
                claims
        );
    }
}
