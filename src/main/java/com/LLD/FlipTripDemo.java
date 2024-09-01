package com.LLD;



import com.LLD.model.AirLines;
import com.LLD.model.Flight;
import com.LLD.model.Passenger;
import com.LLD.services.FlipTripService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class FlipTripDemo {
    public static void main(String[] args) {
        FlipTripService system = new FlipTripService();

        AirLines jetAirFlights = system.createAirline("JetAir");
        AirLines deltaFlights = system.createAirline("Delta");
        AirLines IndigoFlights = system.createAirline("Indigo");

        Passenger passenger = system.createPassenger("U001", "John", "john@example.com", "1234567890");

        // Create flights
        LocalDateTime departureTime1 = LocalDateTime.now().plusDays(1);
        LocalDateTime arrivalTime1 = departureTime1.plusHours(2);
        Flight flight1 = system.createFlight("F001", jetAirFlights, "DEL", "BLR", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 500, "baggage");


        LocalDateTime departureTime2 = LocalDateTime.now().plusDays(3);
        LocalDateTime arrivalTime2 = departureTime2.plusHours(5);


        Flight flight2 = system.createFlight("F003", jetAirFlights, "BLR", "LON", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 1000, "");

        Flight flight3 = system.createFlight("F004", deltaFlights, "LON", "NYC", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 2000, "meal");

        Flight flight4 = system.createFlight("F005", deltaFlights, "DEL", "LON", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 2000, "meal");

        Flight flight5 = system.createFlight("F002", IndigoFlights, "LON", "NYC", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 2500, "meal");

        Flight flight6 = system.createFlight("F003", IndigoFlights, "DEL", "BLR", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 600, "meal");

        Flight flight7 = system.createFlight("F004", IndigoFlights, "BLR", "PAR", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 800, "meal");

        Flight flight8 = system.createFlight("F005", IndigoFlights, "PAR", "LON", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 300, "meal");


        System.out.println("search flight");

        Map<String, List<Flight>> flightsWithMinHops = system.searchFlightsWithMinHop("DEL", "NYC");
        System.out.println("Route with Minimum Hops: ");
        system.print(flightsWithMinHops);

        Map<String, List<Flight>> flightWithMinCost = system.searchFlightsWithMinCost("DEL", "NYC");
        System.out.println("Route with Minimum Cost: ");
        system.print(flightWithMinCost);


        Flight f1 = system.createFlight("F005", IndigoFlights, "DEL", "LON", LocalDateTime.now(), LocalDateTime.now().plusHours(3), 20, 300, "meal");


        system.searchFlightsWithAddOnService("DEL","LON","MealService");



    }

}