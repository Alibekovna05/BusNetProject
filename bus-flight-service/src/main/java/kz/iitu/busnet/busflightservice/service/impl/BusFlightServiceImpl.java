package kz.iitu.busnet.busflightservice.service.impl;

import jakarta.transaction.Transactional;
import kz.iitu.busnet.busflightservice.controller.BusFlightController;
import kz.iitu.busnet.busflightservice.dto.BusFlightRequest;
import kz.iitu.busnet.busflightservice.dto.BusFlightResponse;
import kz.iitu.busnet.busflightservice.exception.BusFlightServiceCustomException;
import kz.iitu.busnet.busflightservice.model.BusFlight;
import kz.iitu.busnet.busflightservice.repository.BusFlightRepository;
import kz.iitu.busnet.busflightservice.service.BusFlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class BusFlightServiceImpl implements BusFlightService {

    private final BusFlightRepository busFlightRepository;

    @Override
    public BusFlightResponse createFlight(BusFlightRequest flightRequest) {

        BusFlight flight = BusFlight.builder()
                .flightNumber(flightRequest.flightNumber())
                .origin(flightRequest.origin())
                .destination(flightRequest.destination())
                .departureDate(flightRequest.departureDate())
                .arrivalDate(flightRequest.arrivalDate())
                .totalSeats(flightRequest.totalSeats())
                .availableSeats(flightRequest.availableSeats())
                .amount(flightRequest.amount())
                .build();

        flight = busFlightRepository.save(flight);

        BusFlightResponse flightResponse = new BusFlightResponse();
        BeanUtils.copyProperties(flight, flightResponse);

        log.info("Flight Created {} ", flightResponse.getFlightId());
        return flightResponse;

    }

    @Override
    public List<BusFlightResponse> getAllFlights() {
        List<BusFlight> flights = busFlightRepository.findAll();
        List<BusFlightResponse> flightResponseList = flights
                .stream()
                .map(this::mapToFlightResponse)
                .collect(Collectors.toList());

        return flightResponseList;
    }

    @Override
    public BusFlightResponse getFlightByNumber(String flightNumber) {
        log.info("Get the flight for flight Number: {}", flightNumber);
        BusFlight optionalFlight = busFlightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(
                        () -> new BusFlightServiceCustomException("Flight with given number not found",
                                "FLIGHT_NOT_FOUND"));

        BusFlightResponse flightResponse = new BusFlightResponse();
        BeanUtils.copyProperties(optionalFlight, flightResponse);

        return flightResponse;

    }

    private BusFlightResponse mapToFlightResponse(BusFlight flight) {
        BusFlightResponse flightResponse = new BusFlightResponse();
        BeanUtils.copyProperties(flight, flightResponse);
        return flightResponse;

    }

    @Override
    @Transactional
    public void reserveSeats(String flightNumber, int seats) {
        log.info("Reserve seats {} for flight Number: {}", seats, flightNumber);

        BusFlight flight = busFlightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(
                        () -> new BusFlightServiceCustomException("Flight with given id not found",
                                "FLIGHT_NOT_FOUND"));

        if (flight.getAvailableSeats() < seats) {
            throw new BusFlightServiceCustomException(
                    "Flights does not have sufficient seats",
                    "INSUFFICIENT_SEATS");
        }

        flight.setAvailableSeats(flight.getAvailableSeats() - seats);
        busFlightRepository.save(flight);
        log.info("Flight Seats details updated Successfully");
    }
}