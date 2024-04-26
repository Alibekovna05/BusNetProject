package kz.iitu.busnet.bookingservice.service.impl;


import jakarta.transaction.Transactional;
import kz.iitu.busnet.bookingservice.dto.BookingRequest;
import kz.iitu.busnet.bookingservice.dto.BookingResponse;
import kz.iitu.busnet.bookingservice.external.client.FlightService;
import kz.iitu.busnet.bookingservice.model.Booking;
import kz.iitu.busnet.bookingservice.repository.BookingRepository;
import kz.iitu.busnet.bookingservice.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@Transactional
@Primary
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {


    private BookingRepository bookingRepository;

    private FlightService flightService;

    @Override
    public String reserveSeats(BookingRequest bookingRequest) {
        log.info("create Booking for user {}", bookingRequest.getPassengerName());

        // set the flight booking status as created
        Booking booking = Booking
                .builder()
                .passengerName(bookingRequest.getPassengerName())
                .flightNumber(bookingRequest.getFlightNumber())
                .seats(bookingRequest.getSeats())
                .bookingNumber(UUID.randomUUID().toString())
                .amount(bookingRequest.getAmount())
                .paymentMode(bookingRequest.getPaymentMode().name())
                .status("BOOKING_CREATED")
                .build();

        bookingRepository.save(booking);

        log.info("booking status is {} ", booking.getStatus());

        flightService.reserveSeats(bookingRequest.getFlightNumber(),
                bookingRequest.getSeats());
        log.info("Seats are reserverd for booking {}", bookingRequest.getFlightNumber());

        return "Booking Id created Succesfully";
    }

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }
}