package kz.iitu.busnet.busflightservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusFlightResponse {
    private Long flightId;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private int totalSeats;
    private int availableSeats;
    private double amount;
}