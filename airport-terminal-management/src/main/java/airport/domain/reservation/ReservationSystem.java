package airport.domain.reservation;

import airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationSystem {
    private HashMap<String, ArrayList<Passenger>> reservations;

    public void addReservation(String flightNumber, Passenger passenger) {
        if (reservations.containsKey(flightNumber)) {
            // get the lis of passenger for flight
            // add passenger to flight passenger list
            ArrayList<Passenger> passengerList = getPassengersForFlight(flightNumber);
            passengerList.add(passenger);

        } else {
            ArrayList<Passenger> newPassengerList = new ArrayList<>();
            newPassengerList.add(passenger);
            reservations.put(flightNumber, newPassengerList);
        }
    }

    public ArrayList<Passenger> getPassengersForFlight(String flightNumber) {
        return reservations.get(flightNumber);
    }
}
