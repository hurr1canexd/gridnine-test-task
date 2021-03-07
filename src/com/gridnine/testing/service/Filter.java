package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public static List<Flight> run(List<Flight> flights, Predicate<Flight> predicate) {
        return flights.stream().
                filter(predicate).
                collect(Collectors.toList());
    }

}
