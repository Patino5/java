package airport.domain.reservation;

import airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationSystem {
    // key - flight number , value - list of passengers
    private HashMap<String, ArrayList<Passenger>> reservations;

    // addReservation(flightNumber, passenger)
    // if fight exist in reservations, get List<passenger> and add passenger to list
    // otherwise: create a new list of passengers and add passenger to list, add flightNumber as a key in reservations HashMap


    // return List<Passenger> || empty list if flight not found
    // getPassengersForFlight(flightNumber)
}
