package kz.iitu.busnet.searchingservice.controller;


import kz.iitu.busnet.searchingservice.dto.FlightSearchRequest;
import kz.iitu.busnet.searchingservice.dto.FlightSearchResponse;
import kz.iitu.busnet.searchingservice.service.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/search")
public class SearchController {

    private final FlightSearchService flightSearchService;

    @GetMapping("/busflights")
    public ResponseEntity<List<FlightSearchResponse>> searchFlights(
            @RequestBody FlightSearchRequest flightSearchRequest) {
        return new ResponseEntity<>(
                flightSearchService.searchFlights(flightSearchRequest), HttpStatus.OK);
    }
}