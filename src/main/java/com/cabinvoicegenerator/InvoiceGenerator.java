package com.cabinvoicegenerator;

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double COST_PER_TIME = 1.0;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        double fare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return (fare < MINIMUM_FARE) ? MINIMUM_FARE : fare;
    }

    public double calculateFare(Ride[] rides) {
        double total_fare = 0;
        for(Ride ride : rides)
            total_fare += calculateFare(ride.getDistance(), ride.getTime());
        return total_fare;
    }
}
