package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.rules.Rule;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private Rule rule;

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public List<Flight> run(List<Flight> flights) {
        return flights.stream()
                .filter(rule::isValid)
                .collect(Collectors.toList());
    }
}
