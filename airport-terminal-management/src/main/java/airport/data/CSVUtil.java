package airport.data;

import airport.domain.model.*;
import airport.domain.reservation.ReservationSystem;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CSVUtil implements ReservationRepository {
    private final String filePath;

    public CSVUtil(String filePath) {
        this.filePath = filePath;
    }

    public ReservationSystem loadReservations() throws IOException {
        // get the hashMap from reservation system to load the data to
        ReservationSystem reservationSystem = new ReservationSystem();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    String flightNumber = parts[0];
                    LocalDate departureDate = LocalDate.parse(parts[1]);
                    BigDecimal ticketPrice = new BigDecimal(parts[2]);
                    String passengerName = parts[3];
                    String passportNumber = parts[4];
                    String aircraftModel = parts[5];
                    String aircraftType = parts[6];

                    // Create aircraft based on type
                    Aircraft aircraft = createAircraft(aircraftType, aircraftModel);

                    // get flight or create a new flight
                    Flight flight = reservationSystem.getFlight(flightNumber);
                    if (flight == null) {
                        flight = new Flight(flightNumber, departureDate, ticketPrice, aircraft);
                        reservationSystem.addFlight(flight);
                    }

                    // Add passenger if not "None" otherwise no passengers on aircraft
                    if (!"None".equals(passengerName) && !"None".equals(passportNumber)) {
                        Passenger passenger = new Passenger(passengerName, passportNumber);
                        reservationSystem.addReservation(flightNumber, passenger);
                    } else {
                        reservationSystem.addReservation(flightNumber);
                    }
                }
            }
        }

        return reservationSystem;
    }

    public void saveReservationsToCSV(ReservationSystem reservations) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            // for each reservation key(flightNumber), get flight with key, list of passenger from flight
            for (String flightNumber : reservations.getReservations().keySet()) {
                Flight flight = reservations.getFlight(flightNumber);
                List<Passenger> passengers = reservations.getPassengersForFlight(flightNumber);

                // flight has no passengers, put "None, None" for passenger data fields
//                if (passengers.isEmpty()) {
//                    writer.println(String.format("%n%s,%s,%s,None,None,%s,%s",
//                            flightNumber,
//                            flight.getDepartureDate(),
//                            flight.getTicketPrice(),
//                            flight.getAircraft().getModel(),
//                            flight.getAircraft().getAircraftType()));
//                } else {

                    // with passengers, get passenger name and passportNumber
                    for (Passenger passenger : passengers) {
                        writer.println(String.format("%n%s,%s,%s,%s,%s,%s,%s",
                                flightNumber,
                                flight.getDepartureDate(),
                                flight.getTicketPrice(),
                                passenger.getName(),
                                passenger.getPassportNumber(),
                                flight.getAircraft().getModel(),
                                flight.getAircraft().getAircraftType()));
//                    }
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Error writing reservation: " + e.getMessage());
        }
    }

    private Aircraft createAircraft(String aircraftType, String model) {
        if (aircraftType.equalsIgnoreCase("Commercial")) {
            return new CommercialAircraft(model, 300, 30000, "Trailblazer");
        } else if (aircraftType.equalsIgnoreCase("PrivateJet")) {
            return new PrivateJet(model, 35, 7500, true, 750);
        } else {
            throw new IllegalArgumentException("Unknown aircraft type: " + aircraftType);
        }
    }
}
