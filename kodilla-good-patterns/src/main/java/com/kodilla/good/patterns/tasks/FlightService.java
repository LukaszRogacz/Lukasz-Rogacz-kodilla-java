package com.kodilla.good.patterns.tasks;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService {

    public void showFlightFrom(Set<Flight> flightList, String departureAirport) {

        if (!getFlightsFrom(flightList, departureAirport).isEmpty()) {
            System.out.println("Flights from " + departureAirport + " :");
            getFlightsFrom(flightList, departureAirport).stream()
                    .forEach(System.out::println);
        } else {
            System.out.println("There are no flights from " + departureAirport);
        }
    }

    public Set<Flight> getFlightsFrom(Set<Flight> flightList, String departureAirport) {
        Set<Flight> setFlights = new HashSet<>();

        setFlights = flightList.stream()
                .filter(s -> s.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toSet());

        return setFlights;
    }

    public Set<Flight> getFlightsTo(Set<Flight> flightList, String arrivalAirport) {
        Set<Flight> setFlights = new HashSet<>();

        setFlights = flightList.stream()
                .filter(s -> s.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());

        return setFlights;
    }

    public void showFlightTo(Set<Flight> flightList, String arrivalAirport) {

        if (!getFlightsTo(flightList, arrivalAirport).isEmpty()) {
            System.out.println("Flights to " + arrivalAirport + " :");
            getFlightsTo(flightList, arrivalAirport).stream()
                    .forEach(System.out::println);
        } else {
            System.out.println("There are no flights to " + arrivalAirport);
        }
    }

    public void showFlightWithTransfer(Set<Flight> flightList, String departureAirport, String arrivalAirport, String transferAirport) {
        if (!getFlightWithTransfer(flightList, departureAirport, arrivalAirport, transferAirport).isEmpty()
                && getFlightWithTransfer(flightList, departureAirport, arrivalAirport, transferAirport).size() == 2) {
            System.out.println("Flights from " + departureAirport + " to " + arrivalAirport + " via " + transferAirport + " :");
            getFlightWithTransfer(flightList, departureAirport, arrivalAirport, transferAirport).stream()
                    .forEach(System.out::println);
        } else {
            System.out.println("There are no flights from " + departureAirport + " to " + arrivalAirport + " via " + transferAirport);
        }
    }

    public Set<Flight> getFlightWithTransfer(Set<Flight> flightList, String departureAirport, String arrivalAirport, String transferAirport) {
        Set<Flight> setFlights = new HashSet<>();

        setFlights = flightList.stream()
                .filter(s -> (s.getDepartureAirport().equals(departureAirport)
                        && s.getArrivalAirport().equals(transferAirport))
                        || (s.getDepartureAirport().equals(transferAirport)
                        && s.getArrivalAirport().equals(arrivalAirport)))
                .collect(Collectors.toSet());
        return setFlights;
    }
}
