package kz.iitu.busnet.bookingservice.repository;


import kz.iitu.busnet.bookingservice.model.BusFlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<BusFlightBooking, Long> {


}