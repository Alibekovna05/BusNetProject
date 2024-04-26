package kz.iitu.busnet.bookingservice.dto;


import lombok.Data;

@Data
public final class FlightBookingRequest extends BookingRequest {
    private String flightNumber;
    private int seats;

}