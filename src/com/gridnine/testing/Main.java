package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // TODO: add debug class
        List<Flight> flights = FlightBuilder.createFlights();

        // output start flights
        System.out.println("Start:");
        printFlightList(flights);

        List<Flight> flights1 = flights.stream().
                filter(x -> FlightValidator.departureUntilCurrentTime(x)).
                collect(Collectors.toList());

        System.out.println("\nAfter first rule:");
        printFlightList(flights1);

        List<Flight> flights2 = flights.stream().
                filter(x -> FlightValidator.arrivalEarlierThanDeparture(x)).
                collect(Collectors.toList());

        System.out.println("\nAfter second rule:");
        printFlightList(flights2);

        List<Flight> flights3 = flights.stream().
                filter(x -> FlightValidator.moreThenTwoHoursOnGround(x)).
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
