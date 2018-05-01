package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public void findFilght (Flight flight) throws RouteNotFoundException{

        Map<String, Boolean> flightMap=new HashMap<>();
        flightMap.put("Poznan",true);
        flightMap.put("Swarzedz",false);
        flightMap.put("Barcelona",true);
        flightMap.put("Madryt",true);
        flightMap.put("Warszawa",false);

        if (( !flightMap.containsKey(flight.getArrivalAirport()))
                ||( !flightMap.containsKey(flight.getDepartureAirport()))
                || ( !flightMap.get(flight.getArrivalAirport()))
                || ( !flightMap.get(flight.getDepartureAirport())) ) {
            throw new RouteNotFoundException();
        }else {
            System.out.println("There is a flight from "+flight.getDepartureAirport()+" to "+flight.getArrivalAirport());
        }
    }
}
