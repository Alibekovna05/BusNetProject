package kz.iitu.busnet.searchingservice.repository;


import kz.iitu.busnet.searchingservice.model.BusFlight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightSearchRepository extends MongoRepository<BusFlight, Long> {

    List<BusFlight> findByOriginAndDestinationAndDepartureDateGreaterThanEqualAndAvailableSeatsGreaterThanEqual(
            String origin, String destination, LocalDate date, int passengers);
}