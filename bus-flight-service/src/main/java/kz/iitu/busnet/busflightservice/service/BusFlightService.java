package kz.iitu.busnet.busflightservice.service;

import kz.iitu.busnet.busflightservice.dto.BusFlightRequest;
import kz.iitu.busnet.busflightservice.dto.BusFlightResponse;

import java.util.List;

public interface BusFlightService {

    BusFlightResponse createFlight(BusFlightRequest flightRequest);

    List<BusFlightResponse> getAllFlights();

    BusFlightResponse getFlightByNumber(String flightNumber);

    public void reserveSeats(String flightNumber, int seats);
}
