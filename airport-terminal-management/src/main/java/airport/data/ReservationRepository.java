package airport.data;

import airport.domain.reservation.ReservationSystem;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReservationRepository {
    ReservationSystem loadReservations() throws IOException;
    void saveReservationsToCSV(ReservationSystem reservations) throws FileNotFoundException;
}
