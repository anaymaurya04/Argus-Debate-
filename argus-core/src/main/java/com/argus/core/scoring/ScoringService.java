package com.argus.core.scoring;

import com.argus.core.domain.CounterArgument;
import com.argus.core.domain.DebateScore;
import com.argus.core.domain.GeneratedArgument;
import org.springframework.stereotype.Service;

@Service
public class ScoringService {

    public DebateScore score(
            GeneratedArgument argument,
            CounterArgument counterArgument
    ) {
        int argumentScore = 10;
        argumentScore -= argument.claims()
                .stream()
                .mapToInt(c -> 0) // placeholder for now
                .sum();

        int counterScore = 10;
        String response = counterArgument.response().toLowerCase();

        if (response.contains("too simplistic")) {
            counterScore += 2;
        }
        if (response.contains("ignores")) {
            counterScore += 4;
        }
        if (response.contains("fails to consider")) {
            counterScore += 6;
        }

        String winner;
        if (argumentScore > counterScore) {
            winner = "ARGUMENT";
        } else if (counterScore > argumentScore) {
            winner = "COUNTER";
        } else {
            winner = "DRAW";
        }

        return new DebateScore(argumentScore, counterScore, winner);
    }
}
