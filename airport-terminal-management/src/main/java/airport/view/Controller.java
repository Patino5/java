package airport.view;

import airport.command.*;
import airport.data.FlightRepository;
import airport.data.ReservationRepository;
import airport.domain.model.Flight;
import airport.domain.reservation.ReservationSystem;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
                case 1 -> new DisplayFlightCommand(reservationSystem, view).execute();
                case 2 -> new AddReservationCommand(view, flightRepo, reservationSystem).execute();
                case 3 -> running = false;
            }
        }
        reservationRepo.saveReservationsToCSV(reservationSystem);
    }


}
