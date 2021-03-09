package com.gridnine.testing.rules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureEarlierThanArrivalRule implements  Rule {
    /**
     * Checks if there are segments with arrival date earlier than departure date
     */
    @Override
    public boolean isValid(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            LocalDateTime arrivalTime = segment.getArrivalDate();
            if (segment.getDepartureDate().isAfter(arrivalTime)) {
                return false;
            }
        }
        return true;
    }
}
