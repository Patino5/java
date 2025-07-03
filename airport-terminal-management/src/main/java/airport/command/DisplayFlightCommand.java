package airport.command;

import airport.domain.model.Flight;
import airport.domain.model.Passenger;
import airport.domain.reservation.ReservationSystem;
import airport.view.View;

import java.util.List;
import java.util.stream.Collectors;

public class DisplayFlightCommand implements Command {
    private final ReservationSystem reservationSystem;
    private final View view;

    public DisplayFlightCommand(ReservationSystem reservationSystem, View view) {
        this.reservationSystem = reservationSystem;
        this.view = view;
    }

    @Override
    public void execute() {
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
}
