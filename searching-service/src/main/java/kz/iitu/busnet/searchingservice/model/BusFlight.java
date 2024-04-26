package kz.iitu.busnet.searchingservice.model;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flights")
public record BusFlight(
        @Id Long id,
        String flightNumber,
        String origin,
        String destination,
        LocalDate departureDate,
        LocalDate arrivalDate,
        double amount,
        int totalSeats,
        int availableSeats) {
}