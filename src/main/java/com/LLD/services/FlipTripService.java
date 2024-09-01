package com.LLD.services;



import com.LLD.AddOnFeatures.*;
import com.LLD.model.Booking;
import com.LLD.model.AirLines;
import com.LLD.model.Flight;
import com.LLD.model.Passenger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipTripService
{
    private final List<Flight> flights;
    private final List<AirLines> airlines;
    private final FlightSearch flightSearch;
    private final BookingManager bookingManager;


    public FlipTripService() {
        flights = new ArrayList<>();
        airlines = new ArrayList<>();
        flightSearch = new FlightSearch(flights);
        bookingManager = BookingManager.getInstance();

    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addAirLines(AirLines air) {
        airlines.add(air);
    }

    public void addAllAirLines(List<AirLines> air) {
        airlines.addAll(air);
    }

    public HashMap<String,List<Flight> >searchFlightsWithMinHop(String source, String destination) {
        return flightSearch.searchFlightswithMinHop(source, destination);
    }

    public HashMap<String,List<Flight> >searchFlightsWithMinCost(String source, String destination) {
        return flightSearch.searchFlightswithMinCost(source, destination);
    }


    public Booking bookFlight(Flight flight, Passenger passenger, int seat, double price) {
        return bookingManager.createBooking(flight, passenger,seat,price);
    }

    public void cancelBooking(String bookingNumber) {
        bookingManager.cancelBooking(bookingNumber);
    }


    public Flight createFlight(String name,AirLines airLines, String s, String d, LocalDateTime des, LocalDateTime arr, int seats,double price,String addOnService) {
        AddOnService addOnService1= AddOnServiceFactory.getAddOnService(addOnService);
        Flight flight = new Flight(name,airLines,s,d,des,arr,seats,price,addOnService1);
        System.out.println(flight.getSource()+ " -> "+ flight.getDestination() +" Flight registered");
        airLines.addFlight(flight);
        flights.add(flight);
        return flight;
    }

    public AirLines createAirline(String jetAir) {
        AirLines air = new AirLines(jetAir);
        airlines.add(air);
        return air;
    }

    public Passenger createPassenger(String id, String name, String mail, String number) {
        Passenger passenger = new Passenger(id, name, mail, number);

        return passenger;
    }

    public void print(Map<String, List<Flight>> flightHops) {
        for(Map.Entry<String, List<Flight>> entry:flightHops.entrySet()){

            int totalPrice= 0;

            for(Flight flight:entry.getValue()){
                System.out.println(flight.getSource() +" to "+ flight.getDestination() + " via " + flight.getAirLines().getName() + " for "+flight.getPrice() );
                totalPrice+= flight.getPrice();
            }
            System.out.println("Total Flights= " + flightHops.get("DEL").size());
            System.out.println("Total Price= " + totalPrice);
        }

    }

    public Map<String, List<Flight>> searchFlightsWithAddOnService(String source, String destination,String addOnService) {
        FlightsWithAddOnService flightSearchwithMeal= new FlightsWithAddOnService(flights);
        List<List<Flight>> flightsWithService=flightSearchwithMeal.searchFlightsWithService(source,destination,addOnService);
        System.out.println("Routes Available :");
        for (List<Flight> flights:flightsWithService) {

            for (Flight flight:flights) {
                System.out.println(flight.getSource()+ " to "+ flight.getDestination() + " via " + flight.getAirLines().getName() + " for "+ flight.getPrice() ) ;
            }
            System.out.println();
        }

        return null;
    }
}
