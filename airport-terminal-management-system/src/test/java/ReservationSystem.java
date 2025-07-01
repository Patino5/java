package airport.domain.reservation;

import airport.domain.model.Passenger;
import airport.domain.model.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ReservationSystem {
    // key - flight number , value - list of passengers
    private HashMap<String, ArrayList<Passenger>> reservations;
    private HashMap<String, Flight> flights;

    public ReservationSystem() {
        this.reservations = new HashMap<>();
        this.flights = new HashMap<>();
    }

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
        reservations.putIfAbsent(flight.getFlightNumber(), new ArrayList<>());
    }

     // add reservation by flight
     public void addReservation(String flightNumber, Passenger passenger) {
        reservations.computeIfAbsent(flightNumber, k -> new ArrayList<>()).add(passenger);
     }

    // get List<passenger> for a flight by flightNumber or empty list []
    public ArrayList<Passenger> getPassengersForFlight(String flightNumber) {
        return reservations.getOrDefault(flightNumber, new ArrayList<>());
    }

    public Flight getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }

    public HashMap<String, ArrayList<Passenger>> getAllReservations() {
        return new HashMap<>(reservations);
    }

    public Set<String> getAllFlightNumbers() {
        return flights.keySet();
    }
}
