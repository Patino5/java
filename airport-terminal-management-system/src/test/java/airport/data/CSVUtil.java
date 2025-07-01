package airport.data;

import airport.domain.model.*;
import airport.domain.reservation.ReservationSystem;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVUtil implements ReservationRepository {
    private final String filePath;
    private final String delimiter = ",";


    public CSVUtil(String filePath) {
        this.filePath = filePath;
    }

    // load existing reservations
    public HashMap<String, ArrayList<Passenger>> findAll() throws DataAccessException {
        HashMap<String, ArrayList<Passenger>> result = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);

                if (parts.length < 7) continue; // skip any line with bad data

                String flightNumber = parts[0];
                String strDepartureDate = parts[1];
                String strTicketPrice = parts[2];
                String passengerName = parts[3];
                String passportNumber = parts[4];
                String aircraftModel = parts[5];
                String aircraftType = parts[6];

                // parse data to required type
                LocalDate departureDate = LocalDate.parse(strDepartureDate);
                BigDecimal ticketPrice = new BigDecimal(strTicketPrice);

                //Create aircraft
                Aircraft aircraft;
                if (aircraftType.equalsIgnoreCase("Commercial")) {
                    aircraft = new CommercialAircraft(aircraftModel, 200, 30000, "AA");
                } else if (aircraftType.equalsIgnoreCase("PrivateJet")) {
                    aircraft = new PrivateJet(aircraftModel, 20, 7500, true, 800);
                } else {
                    continue; // unknown aircraft type
                }

                // Create and add passenger
                if (!passengerName.equalsIgnoreCase("None") && !passengerName.isBlank()) {
                    Passenger passenger = new Passenger(passengerName, passportNumber);

                    // Add to reservation map with good passenger data
                    result.putIfAbsent(flightNumber, new ArrayList<>());
                    result.get(flightNumber).add(passenger);
                    continue;
                }
                // with "None" as passenger name testing purpose
                result.putIfAbsent(flightNumber, new ArrayList<>());
                result.get(flightNumber).add(new Passenger(passengerName, passportNumber));
            }
        } catch (FileNotFoundException e) {
            // if file doesn't exist, it will be created when adding a new reservation.
        } catch (IOException e) {
            throw new DataAccessException("Could not open the file path: " + filePath, e);
        }
        return result;
    }

    @Override
    public void saveReservationsToCSV(ReservationSystem reservations) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(filePath)) {

            for (String flightNumber : reservations.getAllFlightNumbers()) {
                Flight flight = reservations.getFlight(flightNumber);
                ArrayList<Passenger> passengers = reservations.getPassengersForFlight(flightNumber);

                if (passengers.isEmpty()) {
                    // Write flight with no passengers
                    writer.println(String.format("%s,%s,%s,None,None,%s,%s",
                            flightNumber,
                            flight.getDepartureDate(),
                            flight.getTicketPrice(),
                            flight.getAircraft().getModel(),
                            flight.getAircraft()));
                } else {
                    passengers.stream()
                            .forEach(
                                    passenger -> writer.println(String.format(
                                            "%s,%s,%s,%s,%s,%s,%s",
                                            flightNumber,
                                            flight.getDepartureDate(),
                                            flight.getTicketPrice(),
                                            passenger.getName(),
                                            passenger.getPassportNumber(),
                                            flight.getAircraft().getModel(),
                                            flight.getAircraft())));
                }
            }
        } catch (IOException e) {
            throw new DataAccessException("Could not write to file path: " + filePath, e);
        }
    }
}