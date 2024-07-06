package com.kriov569.example;

import com.kriov569.example.model.Distance;
import com.kriov569.example.model.Gender;
import com.kriov569.example.model.Person;
import com.kriov569.example.model.Result;
import com.kriov569.example.service.ResultsProcessor;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsProcessorTest {

    @Test
    void getFastest() {
        // Arrange
        var results = List.of(
        new Result(new Person("A", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(300)),
        new Result(new Person("B", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(250)),
        new Result(new Person("C", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(280)),
        new Result(new Person("D", Gender.FEMALE), Distance.TEN_KM, Duration.ofSeconds(320)),
        new Result(new Person("E", Gender.FEMALE), Distance.TEN_KM, Duration.ofSeconds(350))
        );
        var resultsProcessor = new ResultsProcessor(results);

        // Act
        var fastestMen = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 2);

        // Assert
        assertEquals(2, fastestMen.size());
        assertEquals(Duration.ofSeconds(250), fastestMen.get(0).time());
        assertEquals(Duration.ofSeconds(280), fastestMen.get(1).time());
    }
}
