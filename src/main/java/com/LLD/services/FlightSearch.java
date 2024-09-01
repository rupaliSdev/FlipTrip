package com.LLD.services;

import com.LLD.model.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class FlightSearch {
    private final List<Flight> flightsAvailable;

    public FlightSearch(List<Flight> flights) {
        this.flightsAvailable = flights;
    }

    public List<Flight> getFlightsAvailable() {
        return flightsAvailable;
    }

    public HashMap<String,List<Flight>> searchFlightswithMinHop(String source, String destination) {
        HashMap<String,List<Flight>> flightMap = new HashMap<>();
        List<List<Flight>> flightsHops=searchFlights(source,destination);

        List<Flight> minCostRoute = flightsHops.stream()
                .min(Comparator.comparingDouble(route -> route.size()))
                .orElse(null);

        flightMap.put(source,minCostRoute);
        return flightMap;

    }

    public HashMap<String,List<Flight>> searchFlightswithMinCost(String source, String destination) {
        HashMap<String,List<Flight>> flightMap = new HashMap<>();
        List<List<Flight>> flightsHops=searchFlights(source,destination);

        List<Flight> minCostRoute = flightsHops.stream()
                .min(Comparator.comparingDouble(route ->
                        route.stream().mapToDouble(Flight::getPrice).sum()))// Compare by cost + hops
                .orElse(null);

        flightMap.put(source,minCostRoute);
        return flightMap;

    }


    public List<List<Flight>> searchFlights(String source, String destination) {

        List<List<Flight>> flightsHops=new ArrayList<>();
        List<Flight> flightsFound=new ArrayList<>();
        dfs(source,destination,flightsHops,flightsFound);
        return flightsHops;

    }
    private void dfs(String source, String destination, List<List<Flight>> flightsHops, List<Flight> flightsFound) {
        if (source.equals(destination)) {
            List<Flight> flightsFoundCopy = new ArrayList<>(flightsFound);
            flightsHops.add(flightsFoundCopy);
            return;
        }
        List<Flight> flightsFromSource = flightsAvailable.stream().filter(flight -> flight.getSource().equals(source)).collect(Collectors.toList());
        for (Flight flight : flightsFromSource) {
            flightsFound.add(flight);
            dfs(flight.getDestination(),destination,flightsHops,flightsFound);
            flightsFound.remove(flight);

        }
    }
}
