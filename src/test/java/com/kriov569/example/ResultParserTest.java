package com.kriov569.example;

import com.kriov569.example.model.Distance;
import com.kriov569.example.model.Gender;
import com.kriov569.example.service.ResultParser;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultParserTest {

    @Test
    void parseResult() {
        // Arrange
        var resultParser = new ResultParser();
        var line = "Ахмадеев Ринас,M,10 km,29:01";

        // Act
        var result = resultParser.parseResult(line);

        // Assert
        assertEquals("Ахмадеев Ринас", result.person().name());
        assertEquals(Gender.MALE, result.person().gender());
        assertEquals(Distance.TEN_KM, result.distance());
        assertEquals(Duration.ofSeconds(1741), result.time());
    }
}
