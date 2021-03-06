package com.gridnine.testing;

public class FlightValidator {

    // Вылет до текущего момента времени
    public static boolean departureUntilCurrentTime(Flight flight) {
        return true;
    }

    // Имеются сегменты с датой прилёта раньше даты вылета
    public static boolean arrivalEarlierThanDeparture(Flight flight) {
        return true;
    }

    // Общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
    public static  boolean moreThenTwoHoursOnGround(Flight flight) {
        return true;
    }
}
