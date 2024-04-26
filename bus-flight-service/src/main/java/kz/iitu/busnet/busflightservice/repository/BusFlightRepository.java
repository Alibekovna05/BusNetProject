package kz.iitu.busnet.busflightservice.repository;


import kz.iitu.busnet.busflightservice.model.BusFlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusFlightRepository extends JpaRepository<BusFlight, Long> {

    Optional<BusFlight> findByFlightNumber(String flightNumber);
}