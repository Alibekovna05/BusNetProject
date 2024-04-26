package kz.iitu.busnet.searchingservice.service.impl;


import kz.iitu.busnet.searchingservice.dto.FlightSearchRequest;
import kz.iitu.busnet.searchingservice.dto.FlightSearchResponse;
import kz.iitu.busnet.searchingservice.model.BusFlight;
import kz.iitu.busnet.searchingservice.repository.FlightSearchRepository;
import kz.iitu.busnet.searchingservice.service.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightSearchServiceImpl implements FlightSearchService {

    private final FlightSearchRepository flightSearchRepository;

    public List<FlightSearchResponse> searchFlights(FlightSearchRequest flightSearchRequest) {
        List<BusFlight> flights = flightSearchRepository
                .findByOriginAndDestinationAndDepartureDateGreaterThanEqualAndAvailableSeatsGreaterThanEqual(
                        flightSearchRequest.origin(),
                        flightSearchRequest.destination(),
                        flightSearchRequest.travelDate(),
                        flightSearchRequest.passengers());

        List<FlightSearchResponse> flightSearchResponseList = flights
                .stream()
                .map(this::mapToFlightSearchResponse)
                .collect(Collectors.toList());

        return flightSearchResponseList;
    }

    private FlightSearchResponse mapToFlightSearchResponse(BusFlight flight) {
        FlightSearchResponse flightSearchResponse = new FlightSearchResponse();
        BeanUtils.copyProperties(flight, flightSearchResponse);
        return flightSearchResponse;
    }
}