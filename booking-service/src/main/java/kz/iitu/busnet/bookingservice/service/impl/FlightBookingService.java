package kz.iitu.busnet.bookingservice.service.impl;


import jakarta.transaction.Transactional;
import kz.iitu.busnet.bookingservice.dto.BookingRequest;
import kz.iitu.busnet.bookingservice.dto.BookingResponse;
import kz.iitu.busnet.bookingservice.dto.FlightBookingRequest;
import kz.iitu.busnet.bookingservice.dto.FlightBookingResponse;
import kz.iitu.busnet.bookingservice.model.BookingStatus;
import kz.iitu.busnet.bookingservice.model.BusFlightBooking;
import kz.iitu.busnet.bookingservice.repository.FlightBookingRepository;
import kz.iitu.busnet.bookingservice.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
 @RequiredArgsConstructor
@Qualifier("flightBookingService")
@Slf4j
public class FlightBookingService implements BookingService {

    // @Autowired
    private final FlightBookingRepository flightBookingRepository;

//    @Autowired
//    // @Qualifier("flightService")
//    private FlightService flightService;

    // private final WebClient webClient;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {

        if (!(bookingRequest instanceof FlightBookingRequest)) {
            throw new IllegalArgumentException("Invalid booking type");
        }

        BusFlightBooking flightBooking = mapToFlightBooking(bookingRequest);

        // validate flight Booking

        log.info("create Booking for user {}", bookingRequest.getPassengerName());

        // save the details
        flightBooking = flightBookingRepository.save(flightBooking);

        log.info("booking status is {} ", flightBooking.getStatus());

        // check for seat availability and reduce the seats for flight
//        flightService.reserveSeats(flightBooking.getFlightNumber(),
//                flightBooking.getSeats());
        log.info("Seats are reserverd for booking {}", flightBooking.getFlightNumber());

        FlightBookingResponse flightBookingResponse = new FlightBookingResponse();
        BeanUtils.copyProperties(flightBooking, flightBookingResponse);

        return flightBookingResponse;
    }

    private BusFlightBooking mapToFlightBooking(BookingRequest bookingRequest) {
        FlightBookingRequest flightBookingRequest = (FlightBookingRequest) bookingRequest;

        BusFlightBooking flightBooking = new BusFlightBooking();

        flightBooking.setBookingNumber(UUID.randomUUID().toString());
        flightBooking.setFlightNumber(flightBookingRequest.getFlightNumber());

        flightBooking.setBookingDate(LocalDate.now());
        flightBooking.setPassengerName(flightBookingRequest.getPassengerName());

        flightBooking.setAmount(flightBookingRequest.getAmount());
        flightBooking.setPaymentMode(flightBookingRequest.getPaymentMode().name());
        flightBooking.setStatus(BookingStatus.CREATED.name());

        flightBooking.setSeats(flightBookingRequest.getSeats());

        return flightBooking;

    }

    @Override
    public String reserveSeats(BookingRequest bookingRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reserveBooking'");
    }

}