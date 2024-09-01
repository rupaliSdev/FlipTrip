package com.LLD.services;

import com.LLD.model.Flight;

import java.util.List;

public class FlightsWithAddOnService extends FlightSearch{
    String addOnServiceName;

    public FlightsWithAddOnService(List<Flight> flights) {
        super(flights);
    }


    public List<List<Flight>> searchFlightsWithService(String source, String destination,String addOnService) {

        List<List<Flight>> flights = searchFlights(source,destination);
        //System.out.println(flights.size());
        List<List<Flight>> result = flights.stream().filter((flights1 -> flights1.stream().allMatch((flight -> flight.getAddOnService().getDescription().equalsIgnoreCase(addOnService))))).toList();
        return result;
    }
}
