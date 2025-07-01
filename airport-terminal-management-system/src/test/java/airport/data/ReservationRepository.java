package airport.data;

import airport.domain.model.Passenger;
import airport.domain.reservation.ReservationSystem;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReservationRepository {

    HashMap<String, ArrayList<Passenger>> findAll() throws DataAccessException;

    void saveReservationsToCSV(ReservationSystem reservationSystem) throws DataAccessException;
}
