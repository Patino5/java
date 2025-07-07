package airport.command;

import airport.data.FlightRepository;
import airport.domain.loyalty.VIPPassenger;
import airport.domain.model.Flight;
import airport.domain.model.Passenger;
import airport.domain.reservation.ReservationSystem;
import airport.view.View;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AddReservationCommand implements Command {
    private final View view;
    private final FlightRepository flightRepo;
    private final ReservationSystem reservationSystem;

    public AddReservationCommand(View view, FlightRepository flightRepo, ReservationSystem reservationSystem) {
        this.view = view;
        this.flightRepo = flightRepo;
        this.reservationSystem = reservationSystem;
    }

    @Override
    public void execute() {
        view.displayFlightTable();

        ArrayList<Flight> flights = getFlights();

        int choice = view.getFlightChoice(flights.size()) - 1;
        Flight selectedFlight = flights.get(choice);

        int currentPassengers = reservationSystem.getPassengersForFlight(selectedFlight.getFlightNumber()).size();
        int totalCapacity = selectedFlight.getAircraft().getCapacity();

        if (currentPassengers >= totalCapacity) {
            view.displayMessage("Flight is full, Cannot add more passengers.");
            return;
        }

        String name = view.getPassengerName();
        String passportNumber = view.getPassengerPassport();
        boolean VIPMember = view.isVIPPassenger();

        BigDecimal ticketPrice = getBigDecimal(VIPMember, selectedFlight);

        Passenger passenger = new Passenger(name, passportNumber);
        reservationSystem.addReservation(selectedFlight.getFlightNumber(), passenger);
        view.displayConfirmation(passenger.getName(), selectedFlight.getFlightNumber(), ticketPrice);
    }

    private static BigDecimal getBigDecimal(boolean VIPMember, Flight selectedFlight) {
        BigDecimal ticketPrice;
        if (VIPMember) {
            ticketPrice = new VIPPassenger().applyDiscount(selectedFlight.getTicketPrice());
        } else {
            ticketPrice = selectedFlight.getTicketPrice();
        }
        return ticketPrice;
    }

    private ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = flightRepo.getFlights();

        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            int seatsAvailable = flight.getAircraft().getCapacity() -
                    reservationSystem.getPassengersForFlight(flight.getFlightNumber()).size();

            view.displayFlightRow(i + 1, flight, seatsAvailable);
        }
        return flights;
    }
}
// Refactor using private methods for display