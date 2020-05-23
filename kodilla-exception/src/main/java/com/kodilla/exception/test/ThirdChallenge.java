package com.kodilla.exception.test;

import java.util.HashMap;

public class ThirdChallenge {
    public static void main(String[] args) {
        FlightSpy flightSpy = new FlightSpy(new HashMap<>());
        Flight flight1 = new Flight("Alaska", "New York");
        Flight flight2 = new Flight("Wrocław", "Szczecin");

        try {
            System.out.println(flightSpy.findFilght(flight1));
        } catch (RouteNotFoundException s) {
            System.out.println(s.getMessage());
        }

        try {
            System.out.println(flightSpy.findFilght(flight2));
        } catch (RouteNotFoundException s) {
            System.out.println(s.getMessage());
        }


    }
}
