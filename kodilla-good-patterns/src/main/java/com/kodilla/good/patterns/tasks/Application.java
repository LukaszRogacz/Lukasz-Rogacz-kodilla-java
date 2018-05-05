package com.kodilla.good.patterns.tasks;

import java.util.Set;

public class Application {

    public static void main(String[] args) {


        AirportBase airportBase = new AirportBase();
        Set<Flight> flightList = airportBase.getFlightBase();

        FlightService flightService = new FlightService();

        flightService.showFlightFrom(flightList, "Poznań");
        flightService.showFlightTo(flightList, "Poznań");
        flightService.showFlightWithTransfer(flightList, "Poznań", "Wrocław", "Warszawa");
        flightService.showFlightWithTransfer(flightList, "Poznań", "Warszawa", "Kraków");
    }
}
