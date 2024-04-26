package kz.iitu.busnet.busflightservice.controller;

import kz.iitu.busnet.busflightservice.dto.BusFlightRequest;
import kz.iitu.busnet.busflightservice.dto.BusFlightResponse;
import kz.iitu.busnet.busflightservice.service.BusFlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/busflights")
@RequiredArgsConstructor
@Log4j2
public class BusFlightController {

    private final BusFlightService busFlightService;

    @PostMapping
    public ResponseEntity<BusFlightResponse> createFlight(@RequestBody BusFlightRequest flightRequest) {

        log.info("createFlight");
        var flight = busFlightService.createFlight(flightRequest);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusFlightResponse>> getAllFlights() {
        log.debug("getAllFlights");
        return new ResponseEntity<>(busFlightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public BusFlightResponse getFlightByNumber(@PathVariable("id") String flightNumber) {
        log.info("getFlightByNumber");
        return busFlightService.getFlightByNumber(flightNumber);
    }

    @PutMapping("/reserveSeats/{id}")
    public void reserveSeats(@PathVariable("id") String flightNumber,
                             @RequestParam int seats) {

        busFlightService.reserveSeats(flightNumber, seats);
    }

}
