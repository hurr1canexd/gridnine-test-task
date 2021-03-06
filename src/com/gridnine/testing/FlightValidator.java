package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FlightValidator {
// TODO: rename methods better

    /** Вылет до текущего момента времени или нет */
    public static boolean departureAfterCurrentTime(Flight flight) {
        LocalDateTime timeNow = LocalDateTime.now();
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(timeNow)) {
                return false;
            }
        }
        return true;
    }

    /** Имеются ли сегменты с датой прилёта раньше даты вылета */
    public static boolean arrivalEarlierThanDeparture(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            LocalDateTime arrivalTime = segment.getArrivalDate();
            if (segment.getDepartureDate().isAfter(arrivalTime)) {
                return false;
            }
        }
        return true;
    }

    /** Общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного
     * сегмента и вылетом следующего за ним)
     */
    public static  boolean moreThenTwoHoursOnGround(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long onGroundHours = 0L;
        for (int i = 0; i < (segments.size() - 1); i++) {
            Duration diff = Duration.between(segments.get(i).getArrivalDate(), segments.get(i+1).getDepartureDate());
            onGroundHours += diff.toHours();
            if (onGroundHours > 2) {
                return false;
            }
        }
        return true;
    }
}
