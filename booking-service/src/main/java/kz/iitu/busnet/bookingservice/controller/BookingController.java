package kz.iitu.busnet.bookingservice.controller;

import kz.iitu.busnet.bookingservice.dto.BookingRequest;
import kz.iitu.busnet.bookingservice.dto.BookingResponse;
import kz.iitu.busnet.bookingservice.dto.FlightBookingRequest;
import kz.iitu.busnet.bookingservice.service.BookingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@Log4j2
public class BookingController {

    private final BookingService bookingService;

    private final BookingService flightBookingService;


    public BookingController(BookingService bookingService,
                             @Qualifier("flightBookingService") BookingService flightBookingService) {
        this.bookingService = bookingService;
        this.flightBookingService = flightBookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createBooking(@RequestBody BookingRequest bookingRequest) {
        log.info("Create booking with request {} ", bookingRequest);
        return bookingService.reserveSeats(bookingRequest);

    }

    @PostMapping("/flight")
    public BookingResponse createFlightBooking(@RequestBody FlightBookingRequest flightBookingRequest) {
        log.info("save {} ", flightBookingRequest.getFlightNumber());
        return flightBookingService.createBooking(flightBookingRequest);
    }



}