package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // TODO: add debug class
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Start list:");
        printFlightList(flights);

        List<Flight> flights1 = flights.stream().
                filter(FlightValidator::departureAfterCurrentTime).
                collect(Collectors.toList());

        System.out.println("\nAfter first rule:");
        printFlightList(flights1);

        List<Flight> flights2 = flights.stream().
                filter(FlightValidator::arrivalEarlierThanDeparture).
                collect(Collectors.toList());

        System.out.println("\nAfter second rule:");
        printFlightList(flights2);

        List<Flight> flights3 = flights.stream().
                filter(FlightValidator::moreThenTwoHoursOnGround).
                collect(Collectors.toList());

        System.out.println("\nAfter third rule:");
        printFlightList(flights3);

    }

    private static void printFlightList(List<Flight> list) {
        for (Flight item: list) {
            System.out.println(item);
        }
    }

}
