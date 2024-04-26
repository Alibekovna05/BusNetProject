package kz.iitu.busnet.bookingservice.service;


import kz.iitu.busnet.bookingservice.dto.BookingRequest;
import kz.iitu.busnet.bookingservice.dto.BookingResponse;

public interface BookingService {

    public BookingResponse createBooking(BookingRequest bookingRequest);

    public String reserveSeats(BookingRequest bookingRequest);

}