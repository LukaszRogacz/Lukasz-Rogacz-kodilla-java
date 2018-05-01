package com.kodilla.exception.test;

public class ThirdChallenge {
    public static void main(String[] args) {
        Flight myFlight=new Flight("Barcelonaa","Poznan");
        FlightFinder flightFinder=new FlightFinder();
        try {
            flightFinder.findFilght(myFlight);
        } catch (RouteNotFoundException e){
            System.out.println("At least one of the airports is not operating");
        }
    }
}
