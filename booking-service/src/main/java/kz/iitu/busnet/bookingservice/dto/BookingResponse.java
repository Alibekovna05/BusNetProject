package kz.iitu.busnet.bookingservice.dto;

import java.time.LocalDate;

import lombok.Data;

@Data

public sealed class BookingResponse permits FlightBookingResponse {

    private Long id;

    private String bookingNumber;
    private String passengerName;
    private String status;
    private double amount;
    private String paymentMode;
    private LocalDate bookingDate;
}