package com.LLD.model;


import com.LLD.AddOnFeatures.AddOnService;


import java.time.LocalDateTime;


public class Flight {
    private final String flightNumber;
    private final String source;
    private final String destination;
    private final AirLines airLines;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final int availableSeats;
    private double price;
    private AddOnService addOnService;

    public Flight(String flightNumber,AirLines airLines, String source, String destination,LocalDateTime departureTime, LocalDateTime arrivalTime,int availableSeats,double price,AddOnService addOnService) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.airLines = airLines;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.price = price;
        this.addOnService=addOnService;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public AirLines getAirLines() {
        return airLines;
    }

    public double getPrice() {
        return price;
    }

    public AddOnService getAddOnService() {
        return addOnService;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", airLines=" + airLines +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                ", addOnService=" + addOnService +
                '}';
    }
}
