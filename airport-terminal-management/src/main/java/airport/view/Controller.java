package airport.view;

import airport.data.FlightRepository;
import airport.data.ReservationRepository;
import airport.domain.model.Flight;
import airport.domain.model.Passenger;
import airport.domain.reservation.ReservationSystem;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final View view;
    private final FlightRepository flightRepo;
    private final ReservationSystem reservationSystem;
    private final ReservationRepository reservationRepo;

    public Controller(View view, FlightRepository flightRepo, ReservationSystem reservationSystem, ReservationRepository reservationRepo) {
        this.view = view;
        this.flightRepo = flightRepo;
        this.reservationSystem = reservationSystem;
        this.reservationRepo = reservationRepo;

        ArrayList<Flight> flights = flightRepo.getFlights();
        reservationSystem.initializeFlights(flights);
    }

    public void run() throws FileNotFoundException {
        boolean running = true;
        while (running) {

            int choice = view.displayMenu();

            switch (choice) {
                case 1 -> displayFlights();
                case 2 -> addReservation();
                case 3 -> running = false;
            }
        }
        reservationRepo.saveReservationsToCSV(reservationSystem);
    }

    private void displayFlights() {
        for (String flightNumber : reservationSystem.getReservations().keySet()) {
            Flight flight = reservationSystem.getFlight(flightNumber);
            int totalSeats = flight.getAircraft().getCapacity();
            int occupiedSeats = reservationSystem.getPassengersForFlight(flight.getFlightNumber()).size();
            int seatsAvailable = totalSeats - occupiedSeats;

            List<Passenger> passengers = reservationSystem.getPassengersForFlight(flightNumber);
            String passengersList = passengers.isEmpty()
                    ? "No passengers yet."
                    : passengers.stream()
                    .map(Passenger::getName)
                    .collect(Collectors.joining(", "));

            view.displayFlightDetails(flightNumber, seatsAvailable,
                    totalSeats, passengersList);
        }
    }

    private void addReservation() {
        view.displayFlightTable();

        ArrayList<Flight> flights = flightRepo.getFlights();

        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            int seatsAvailable = flight.getAircraft().getCapacity() -
                    reservationSystem.getPassengersForFlight(flight.getFlightNumber()).size();

            view.displayFlightRow(i + 1, flight, seatsAvailable);
        }

        int choice = view.getFlightChoice(flights.size()) - 1;
        Flight selectedFlight = flights.get(choice);

        String name = view.getPassengerName();
        String passportNumber = view.getPassengerPassport();
        Passenger passenger = new Passenger(name, passportNumber);

        reservationSystem.addReservation(selectedFlight.getFlightNumber(), passenger);
        view.displayConfirmation(passenger.getName(), selectedFlight.getFlightNumber());
    }

}
