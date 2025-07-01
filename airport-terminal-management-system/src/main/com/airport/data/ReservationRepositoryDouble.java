package airport.data;

import airport.domain.model.Passenger;
import airport.domain.reservation.ReservationSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationRepositoryDouble implements ReservationRepository {
    private HashMap<String, ArrayList<Passenger>> mockReservations = new HashMap<>();

    public ReservationRepositoryDouble() {
        ArrayList<Passenger> testPassengerList1 = new ArrayList<>();
        testPassengerList1.add(new Passenger("person1", "123456"));
        testPassengerList1.add(new Passenger("person2", "234567"));
        testPassengerList1.add(new Passenger("person3", "345678"));
        testPassengerList1.add(new Passenger("person4", "456789"));
        mockReservations.put("BB456", testPassengerList1);
    }



    @Override
    public HashMap<String, ArrayList<Passenger>> findAll() throws DataAccessException {
        HashMap<String, ArrayList<Passenger>> result = new HashMap<>();
        for (String flightNumber : mockReservations.keySet()) {
            ArrayList<Passenger> originalPassengerList = mockReservations.get(flightNumber);
            ArrayList<Passenger> copyPassengers = new ArrayList<>();

            for (Passenger passenger : originalPassengerList) {
                copyPassengers.add(new Passenger(passenger.getName(), passenger.getPassportNumber()));
            }
            result.put(flightNumber, copyPassengers);
        }
        return result;
    }

    @Override
    public void saveReservationsToCSV(ReservationSystem reservationSystem) throws DataAccessException {
        mockReservations.clear();

        if (reservationSystem != null) {
            for (String flightNumber : reservationSystem.getAllFlightNumbers()) {
                ArrayList<Passenger> passengers = reservationSystem.getPassengersForFlight(flightNumber);
                ArrayList<Passenger> copyPassengers = new ArrayList<>();

                if (passengers != null) {
                    for (Passenger passenger : passengers) {
                        copyPassengers.add(new Passenger(passenger.getName(), passenger.getPassportNumber()));
                    }
                }
                mockReservations.put(flightNumber, copyPassengers);
            }
        }
    }
}
