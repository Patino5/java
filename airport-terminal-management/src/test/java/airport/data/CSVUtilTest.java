package airport.data;

import airport.domain.model.CommercialAircraft;
import airport.domain.model.Flight;
import airport.domain.model.Passenger;
import airport.domain.reservation.ReservationSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVUtilTest {

    static final String SEED_FILE_PATH = "./data/reservations-seed.txt";
    static final String TEST_FILE_PATH = "./data/reservations-test.txt";

    CSVUtil repository = new CSVUtil(TEST_FILE_PATH);


    @BeforeEach
    void setupTest() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void loadReservations() throws IOException {
        HashMap<String, ArrayList< Passenger>> actual = repository.loadReservations().getReservations();
        assertEquals(3, actual.size());
        String passengerName = actual.get("AA101").getFirst().getName();
        assertEquals("Alice Smith", passengerName);

        String passengerName2 = actual.get("BB202").getFirst().getName();
        assertEquals("John Doe", passengerName2);

        int flightPJ001PassengerList = actual.get("PJ001").size();
        assertEquals(0, flightPJ001PassengerList);
    }

    @Test
    void shouldSaveAndLoadReservationsWithPassenger() throws IOException  {
        ReservationSystem originalSystem = new ReservationSystem();
        Flight flight = createSampleFlight("FL101");
        originalSystem.addFlight(flight);
        originalSystem.addReservation("FL101", new Passenger("Ryan", "123456"));

        repository.saveReservationsToCSV(originalSystem);

        ReservationSystem loadedSystem = repository.loadReservations();

        Flight  loadedFlight = loadedSystem.getFlight("FL101");
        List<Passenger> passengers = loadedSystem.getPassengersForFlight("FL101");

        assertNotNull(loadedFlight);
        assertEquals("FL101", loadedFlight.getFlightNumber());
        assertEquals(1, passengers.size());
        assertEquals("Ryan", passengers.getFirst().getName());
        assertEquals("123456", passengers.getFirst().getPassportNumber());
    }
    private Flight createSampleFlight(String flightNumber) {
        return new Flight(
                flightNumber,
                LocalDate.of(2025, 12, 25),
                new BigDecimal("1000.00"),
                new CommercialAircraft("G650", 10, 5000, "Trailblazer")
        );
    }
}