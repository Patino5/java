package airport.domain.reservation;

import airport.domain.model.Flight;
import airport.domain.model.Passenger;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationSystem {
    private final HashMap<String, ArrayList<Passenger>> reservations;
    private final HashMap<String, Flight> flights;

    public ReservationSystem() {
        this.reservations = new HashMap<>();
        this.flights = new HashMap<>();
    }

    public HashMap<String, ArrayList<Passenger>> getReservations() {
        return new HashMap<>(reservations);
    }

    public void initializeFlights(ArrayList<Flight> flights) {
        for (Flight flight : flights) {
            this.flights.put(flight.getFlightNumber(), flight);
            this.reservations.putIfAbsent(flight.getFlightNumber(), new ArrayList<>());
        }
    }

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
        reservations.putIfAbsent(flight.getFlightNumber(), new ArrayList<>());
    }

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

    public void addReservation(String flightNumber) {
        ArrayList<Passenger> emptyPassengerList = new ArrayList<>();
        reservations.put(flightNumber, emptyPassengerList);
    }

    public ArrayList<Passenger> getPassengersForFlight(String flightNumber) {
        return reservations.get(flightNumber);
    }

    public Flight getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }
}
