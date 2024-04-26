package kz.iitu.busnet.searchingservice.dataloader;


import kz.iitu.busnet.searchingservice.model.BusFlight;
import kz.iitu.busnet.searchingservice.repository.FlightSearchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class FlightDataLoader implements CommandLineRunner {
    private final FlightSearchRepository flightSearchRepository;

    public FlightDataLoader(FlightSearchRepository flightSearchRepository) {
        this.flightSearchRepository = flightSearchRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Remove existing flights (optional)
        flightSearchRepository.deleteAll();

        // Create sample flights
        BusFlight flight1 = new BusFlight(1l, "EK203", "Taraz", "Almaty",
                LocalDate.parse("2024-04-23"), LocalDate.parse("2024-04-23"), 5000.00, 60, 40);
        BusFlight flight2 = new BusFlight(2l, "EK204", "Almaty", "Bishkek",
                LocalDate.parse("2024-04-22"), LocalDate.parse("2024-04-24"), 7000.00, 40, 32);
        BusFlight flight3 = new BusFlight(3l, "EK205", "Almaty", "Zharkent",
                LocalDate.parse("2024-04-25"), LocalDate.parse("2024-04-27"), 9000.00, 55, 55);

        // Save flights to the database
        flightSearchRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

    }
}