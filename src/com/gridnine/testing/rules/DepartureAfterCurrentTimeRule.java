package com.gridnine.testing.rules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;

public class DepartureAfterCurrentTimeRule implements Rule {
    /**
     * Checks the departure time after the current time
     */
    @Override
    public boolean isValid(Flight flight) {
        LocalDateTime timeNow = LocalDateTime.now();
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(timeNow)) {
                return false;
            }
        }
        return true;
    }
}
