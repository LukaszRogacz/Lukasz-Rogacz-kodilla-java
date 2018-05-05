package com.kodilla.good.patterns.tasks;

import java.util.HashSet;
import java.util.Set;

public class AirportBase {

    private static final String AIRPORT_POZNAN = "Poznań";
    private static final String AIRPORT_WARSZAWA = "Warszawa";
    private static final String AIRPORT_GDANSK = "Gdańsk";
    private static final String AIRPORT_KATOWICE = "Katowice";
    private static final String AIRPORT_WROCLAW = "Wrocław";

    public Set<Flight> getFlightBase() {

        final Set<Flight> flightList = new HashSet<>();

        flightList.add(new Flight(AIRPORT_POZNAN, AIRPORT_WARSZAWA));
        flightList.add(new Flight(AIRPORT_POZNAN, AIRPORT_GDANSK));
        flightList.add(new Flight(AIRPORT_POZNAN, AIRPORT_WROCLAW));
        flightList.add(new Flight(AIRPORT_WARSZAWA, AIRPORT_POZNAN));
        flightList.add(new Flight(AIRPORT_WARSZAWA, AIRPORT_GDANSK));
        flightList.add(new Flight(AIRPORT_WARSZAWA, AIRPORT_KATOWICE));
        flightList.add(new Flight(AIRPORT_WARSZAWA, AIRPORT_WROCLAW));
        flightList.add(new Flight(AIRPORT_GDANSK, AIRPORT_POZNAN));
        flightList.add(new Flight(AIRPORT_GDANSK, AIRPORT_KATOWICE));
        flightList.add(new Flight(AIRPORT_KATOWICE, AIRPORT_WROCLAW));
        flightList.add(new Flight(AIRPORT_KATOWICE, AIRPORT_GDANSK));
        flightList.add(new Flight(AIRPORT_KATOWICE, AIRPORT_WARSZAWA));
        flightList.add(new Flight(AIRPORT_WROCLAW, AIRPORT_POZNAN));
        flightList.add(new Flight(AIRPORT_WROCLAW, AIRPORT_WARSZAWA));
        flightList.add(new Flight(AIRPORT_WROCLAW, AIRPORT_KATOWICE));

        return flightList;
    }
}
