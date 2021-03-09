package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.rules.DepartureAfterCurrentTimeRule;
import com.gridnine.testing.rules.DepartureEarlierThanArrivalRule;
import com.gridnine.testing.rules.LessThanTwoHoursGroundTimeRule;
import com.gridnine.testing.util.Debug;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Getting the initial list
        List<Flight> flights = FlightBuilder.createFlights();
        Debug.Write("Start list:");
        Debug.Write(flights);

        Filter filter = new Filter();

        // Getting filtered lists
        filter.setRule(new DepartureEarlierThanArrivalRule());
        List<Flight> firstRuleFlights = filter.run(flights);
        Debug.Write("\nFirst rule list:");
        Debug.Write(firstRuleFlights);

        filter.setRule(new DepartureAfterCurrentTimeRule());
        List<Flight> secondRuleFlights = filter.run(flights);
        Debug.Write("\nSecond rule list:");
        Debug.Write(secondRuleFlights);

        filter.setRule(new LessThanTwoHoursGroundTimeRule());
        List<Flight> thirdRuleFlights = filter.run(flights);
        Debug.Write("\nThird rule list:");
        Debug.Write(thirdRuleFlights);
    }
}
