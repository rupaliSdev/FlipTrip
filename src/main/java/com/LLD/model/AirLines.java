package com.LLD.model;

import java.util.ArrayList;
import java.util.List;

public class AirLines {
    private final String name;
    private final List<Flight> flights;


    public AirLines(String name) {
       this.name = name;
       this.flights =new ArrayList<>();
    }

    public  Flight addFlight(Flight flight){
        flights.add(flight);
        return flight;
    }
    public String getName() {
        return name;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
