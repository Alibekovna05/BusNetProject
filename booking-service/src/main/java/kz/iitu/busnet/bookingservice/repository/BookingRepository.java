package kz.iitu.busnet.bookingservice.repository;


import kz.iitu.busnet.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}