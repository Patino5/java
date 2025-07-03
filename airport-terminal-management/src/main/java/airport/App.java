package airport;

import airport.data.CSVUtil;
import airport.data.SampleFlightRepository;
import airport.domain.reservation.ReservationSystem;
import airport.view.ConsoleIO;
import airport.view.Controller;
import airport.view.TextIO;
import airport.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "data/reservations.csv";
        CSVUtil csvUtil = new CSVUtil(filePath);
        ReservationSystem reservationSystem = new ReservationSystem();
        SampleFlightRepository flightRepo = new SampleFlightRepository();
        TextIO io = new ConsoleIO();
        View view = new View(io);

        try {
            reservationSystem = csvUtil.loadReservations();
            io.println("Successful load");

        } catch (IOException e) {
            io.println("Failed to read from file: " + e.getMessage());
            reservationSystem = new ReservationSystem();
            reservationSystem.initializeFlights(flightRepo.getFlights());
        }

        Controller controller = new Controller(view, flightRepo, reservationSystem, csvUtil);
        controller.run();
    }
}
