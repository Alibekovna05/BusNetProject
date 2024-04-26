package kz.iitu.busnet.bookingservice.external.client;


import kz.iitu.busnet.bookingservice.exception.BookingException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "flight-service", url = "http://localhost:8082/api/busflights")

public interface FlightService {

    @PutMapping("/reserveSeats/{id}")
    public void reserveSeats(@PathVariable("id") String flightNumber,
                             @RequestParam int seats);

    default void fallback(Exception e) {
        throw new BookingException("Flight Service is not available",
                "UNAVAILABLE",
                500);
    }
}