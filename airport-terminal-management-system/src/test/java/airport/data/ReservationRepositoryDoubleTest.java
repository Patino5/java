package airport.data;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRepositoryDoubleTest {

    @Test
    void testFindAll() throws DataAccessException {
        ReservationRepositoryDouble repo = new ReservationRepositoryDouble();

        HashMap<String, ArrayList<Passenger>> reservations = repo.findAll();

        assertNotNull(reservations);
        assertEquals(1, reservations.size());
        assertTrue(reservations.containsKey("BB456"));
        assertEquals(4, reservations.get("BB456").size());
    }

    @Test
    void testSaveOperation() throws DataAccessException {
        ReservationRepositoryDouble repo = new ReservationRepositoryDouble();
        ReservationSystem mockSystem = mock(ReservationSystem.class);


        ArrayList<Passenger> testPassengerList2 = new ArrayList<>();
        testPassengerList2.add(new Passenger("person1", "123456"));
        testPassengerList2.add(new Passenger("person2", "234567"));
        testPassengerList2.add(new Passenger("person3", "345678"));
        reservations.put("BB456", testPassengerList2);

        repo.saveReservationsToCSV(mockSystem);
    }

}