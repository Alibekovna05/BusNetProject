package kz.iitu.busnet.bookingservice.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("FLIGHT")
public class BusFlightBooking extends Booking {
    private String flightNumber;
}