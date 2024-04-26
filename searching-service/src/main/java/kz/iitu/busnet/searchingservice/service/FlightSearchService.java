package kz.iitu.busnet.searchingservice.service;


import kz.iitu.busnet.searchingservice.dto.FlightSearchRequest;
import kz.iitu.busnet.searchingservice.dto.FlightSearchResponse;

import java.util.List;

public interface FlightSearchService {

    public List<FlightSearchResponse> searchFlights(FlightSearchRequest flightSearchRequest);
}