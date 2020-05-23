package com.kodilla.exception.test;

import java.util.Map;

public class FlightSpy {

    private Map<String, Boolean> mapOfFlights;

    public FlightSpy(Map<String, Boolean> mapOfFlights) {
        mapOfFlights.put("Alaska", true);
        mapOfFlights.put("Berlin", true);
        mapOfFlights.put("Sydney", true);
        mapOfFlights.put("London", true);
        mapOfFlights.put("New York", true);
        mapOfFlights.put("Birmingham", true);
        mapOfFlights.put("Warsaw", true);
        this.mapOfFlights = mapOfFlights;
    }

    public String findFilght(Flight flight) throws RouteNotFoundException {
        String result = mapOfFlights.keySet().stream()
                .filter(s -> s.equals(flight.getArrivalAirport()))
                .findFirst()
                .orElseThrow(() -> new RouteNotFoundException("nie znaleziono lotu"));

        return "lot do " + flight.getArrivalAirport() + " jest możliwy: " + mapOfFlights.get(result);
    }
}
