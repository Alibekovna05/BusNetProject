package kz.iitu.busnet.bookingservice.dto;


import lombok.Data;

@Data
public final class FlightBookingResponse extends BookingResponse {
    private String flightNumber;
}