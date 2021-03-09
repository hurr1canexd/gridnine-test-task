package com.gridnine.testing.rules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.List;

public class LessThanTwoHoursGroundTimeRule implements  Rule {
    /**
     * Checks if the total time spent on the ground is less than two hours
     * (time on the ground is the interval between the arrival of one segment and the departure of the next one)
     */
    @Override
    public boolean isValid(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long onGroundHours = 0L;
        for (int i = 0; i < (segments.size() - 1); i++) {
            Duration diff = Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate());
            onGroundHours += diff.toHours();
            if (onGroundHours > 2) {
                return false;
            }
        }
        return true;
    }
}
