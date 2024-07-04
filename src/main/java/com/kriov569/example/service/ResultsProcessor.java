package com.kriov569.example.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.kriov569.example.model.Distance;
import com.kriov569.example.model.Gender;
import com.kriov569.example.model.Result;

public class ResultsProcessor {

    private final Collection<Result> results;

    public ResultsProcessor(Collection<Result> results) {
        this.results = results;
    }

    /**
     * Позволяет определить N самых быстрых мужчин или женщин на дистанции 5 или 10 км.
     * </p>
     * Пример запроса - найти 3 самых быстрых женщин на дистанции 10 км.
     */
    public List<Result> getFastest(Gender gender, Distance distance, int limit) {
        return results.stream()
                .filter(result -> result.hasDistance(distance) && result.hasGender(gender))
                .sorted(Comparator.comparing(Result::time))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
