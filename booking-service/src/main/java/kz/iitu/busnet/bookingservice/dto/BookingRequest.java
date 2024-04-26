package kz.iitu.busnet.bookingservice.dto;

import lombok.Data;

@Data
public sealed class BookingRequest permits FlightBookingRequest {

    String passengerName;
    double amount;
    PaymentMode paymentMode;
    private String flightNumber;
    private int seats;
}