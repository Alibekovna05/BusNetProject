package kz.iitu.busnet.busflightservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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