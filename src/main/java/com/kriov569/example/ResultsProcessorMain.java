package com.kriov569.example;

import java.io.IOException;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import com.kriov569.example.config.ResultsProcessorConfig;
import com.kriov569.example.model.Distance;
import com.kriov569.example.model.Gender;
import com.kriov569.example.model.Result;
import com.kriov569.example.service.ResultsProcessor;
import com.kriov569.example.service.ResultsReader;

public class ResultsProcessorMain {

    public static void main(String[] args) throws IOException {
        var applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);

        var resultsReader = applicationContext.getBean(ResultsReader.class);
        var filePath = new ClassPathResource("results.csv").getFile().toPath();
        var results = resultsReader.readFromFile(filePath);

        var resultsProcessor = new ResultsProcessor(results);
        List<Result> fastestMen = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 3);

        System.out.println(fastestMen);
    }
}