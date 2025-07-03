package airport.domain.reservation;

import airport.domain.model.Flight;
import airport.domain.model.Passenger;
import airport.domain.model.PrivateJet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationSystemTest {

    ReservationSystem reservations;

    @BeforeEach
    void setup() {
        reservations = new ReservationSystem();
    }

    @Test
    void shouldAddAndRetrieveFlight() {
        Flight flight = createSampleFlight("FL001");
        reservations.addFlight(flight);

        Flight result = reservations.getFlight("FL001");

        assertNotNull(result);
        assertEquals("FL001", result.getFlightNumber());
    }

    @Test
    void shouldAddReservationWithPassenger() {
        Flight flight = createSampleFlight("FL002");
        reservations.addFlight(flight);

        Passenger passenger = new Passenger("Ryan", "345678765");
        reservations.addReservation("FL002", passenger);
        List<Passenger> passengers = reservations.getPassengersForFlight("FL002");

        assertEquals(1, passengers.size());
        assertEquals("Ryan", passengers.getFirst().getName());
    }

    @Test
    void emptyPassengerListForFlight() {
        Flight flight = createSampleFlight("FL003");
        reservations.addFlight(flight);

        reservations.addReservation(flight.getFlightNumber());

        List<Passenger> passengers = reservations.getPassengersForFlight("FL003");

        assertTrue(passengers.isEmpty());
    }

    @Test
    void shouldInitializeFlights() {
        Flight f1 = createSampleFlight("FL004");
        Flight f2 = createSampleFlight("FL005");
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(f1);
        flights.add(f2);

        reservations.initializeFlights(flights);

        assertEquals(2, reservations.getReservations().size());
        assertNotNull(reservations.getFlight("FL004"));
        assertNotNull(reservations.getFlight("FL005"));
    }

    @Test
    void testReservationSystem() {
        Passenger p1 = new Passenger("TestPassenger1", "123456");
        String flightNumber = "TestFlightNum";

        assertEquals(0, reservations.getReservations().size());

        reservations.addReservation(flightNumber, p1);
        int actual = reservations.getPassengersForFlight("TestFlightNum").size();
        assertEquals(1, actual);

        String passengerName = reservations.getPassengersForFlight("TestFlightNum").getFirst().getName();
        assertEquals("TestPassenger1", passengerName);

        Passenger p2 = new Passenger("TestPassenger2", "546372819");
        Passenger p3 = new Passenger("TestPassenger3", "987654");
        Passenger p4 = new Passenger("TestPassenger4", "912837465");
        reservations.addReservation(flightNumber, p2);
        reservations.addReservation(flightNumber, p3);
        reservations.addReservation("flight23", p4);

        assertEquals(3, reservations.getPassengersForFlight(flightNumber).size());
        assertEquals(1, reservations.getPassengersForFlight("flight23").size());

        assertTrue(reservations.getReservations().containsKey(flightNumber));
        assertTrue(reservations.getReservations().containsKey("flight23"));

    }

    private Flight createSampleFlight(String flightNumber) {
        return new Flight(
                flightNumber,
                LocalDate.now().plusDays(1),
                new BigDecimal("10000.00"),
                new PrivateJet("G650", 10, 5000, true, 800)
        );
    }
}
