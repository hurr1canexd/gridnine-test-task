package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Class that provides rules for filtering flights
 */
public class FlightValidator {

    /**
     * Checks the departure time after the current time
     */
    public static boolean departureAfterCurrentTime(Flight flight) {
        LocalDateTime timeNow = LocalDateTime.now();
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(timeNow)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there are segments with arrival date earlier than departure date
     */
    public static boolean departureEarlierThanArrival(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            LocalDateTime arrivalTime = segment.getArrivalDate();
            if (segment.getDepartureDate().isAfter(arrivalTime)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the total time spent on the ground is less than two hours
     * (time on the ground is the interval between the arrival of one segment and the departure of the next one)
     */
    public static boolean lessThanTwoHoursGroundTime(Flight flight) {
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
