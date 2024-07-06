package com.kriov569.example;

import com.kriov569.example.model.Distance;
import com.kriov569.example.model.Gender;
import com.kriov569.example.service.ResultParser;
import com.kriov569.example.service.ResultsReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsReaderTest {

    @Test
    void readFromFile() throws IOException {
        // Arrange
        var resultParser = new ResultParser();
        var resultsReader = new ResultsReader(resultParser);
        var filePath = Paths.get("src/test/resources/results.csv");

        // Act
        var results = resultsReader.readFromFile(filePath);

        // Assert
        assertEquals(20, results.size());
        assertEquals("Ахмадеев Ринас", results.get(0).person().name());
        assertEquals(Gender.MALE, results.get(0).person().gender());
        assertEquals(Distance.TEN_KM, results.get(0).distance());
        assertEquals(Duration.ofSeconds(1741), results.get(0).time());
    }
}
