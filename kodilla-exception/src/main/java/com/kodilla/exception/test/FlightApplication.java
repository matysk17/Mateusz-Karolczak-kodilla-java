package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;


public class FlightApplication {
    public static void main(String[] args) {
        Map<String, Boolean> activeAirports = new HashMap<>();
        activeAirports.put("Warsaw",true);
        activeAirports.put("Berlin",false);
        activeAirports.put("London",true);
        activeAirports.put("Dublin",false);
        activeAirports.put("Liverpool",true);

        FlightFinder availableAirports = new FlightFinder(activeAirports);

        Flight flight = new Flight("Warsaw","Heaven");

        try {
            if (availableAirports.findFlight(flight)) {
                System.out.println("Fly available");
            } else {
                System.out.println("Fly not available");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Fly is impossible!!!");
            }
        }
    }

