package com.kodilla.exception.test;

import java.util.Map;

public class FlightFinder {
    private Map<String,Boolean> actualAvailableAirports;

    public FlightFinder(Map<String,Boolean>actualAvailableAirports) {
        this.actualAvailableAirports = actualAvailableAirports;
    }
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        if (!actualAvailableAirports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException();
        }
        return actualAvailableAirports.get(flight.getArrivalAirport());
    }

}
