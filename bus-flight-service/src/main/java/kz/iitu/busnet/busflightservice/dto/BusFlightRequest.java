package kz.iitu.busnet.busflightservice.dto;


import lombok.Builder;

import java.time.LocalDate;

@Builder
public record BusFlightRequest(
        String flightNumber,
        String origin,
        String destination,
        LocalDate departureDate,
        LocalDate arrivalDate,
        int totalSeats,
        int availableSeats,
        double amount) {

}