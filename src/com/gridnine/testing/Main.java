package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.Filter;
import com.gridnine.testing.service.FlightValidator;
import com.gridnine.testing.util.Debug;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        Debug.Write("Start list:");
        Debug.Write(flights);

        List<Flight> flights1 = Filter.run(flights, FlightValidator::departureEarlierThanArrival);
        Debug.Write("\nAfter first rule:");
        Debug.Write(flights1);

        List<Flight> flights2 = Filter.run(flights, FlightValidator::departureAfterCurrentTime);
        Debug.Write("\nAfter second rule:");
        Debug.Write(flights2);

        List<Flight> flights3 = Filter.run(flights, FlightValidator::lessThanTwoHoursGroundTime);
        Debug.Write("\nAfter third rule:");
        Debug.Write(flights3);
    }

}
