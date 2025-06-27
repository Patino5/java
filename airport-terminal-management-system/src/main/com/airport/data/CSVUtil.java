package airport.data;

import airport.domain.model.Aircraft;
import airport.domain.model.CommercialAircraft;
import airport.domain.model.Passenger;
import airport.domain.model.PrivateJet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVUtil {
    private final String filePath;
    private final String delimiter = ",";

    public CSVUtil(String filePath) {
        this.filePath = filePath;
    }

    // load existing reservations
    public HashMap<String, ArrayList<Passenger>> loadReservationsFromCSV(String filePath) throws DataAccessException {
        HashMap<String, ArrayList<Passenger>> result = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(delimiter);

//                if (parts.length < 7) continue; // skip any line with bad data

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
                    aircraft = new CommercialAircraft(aircraftModel, 200, 30000,"AA");
                } else if (aircraftType.equalsIgnoreCase("PrivateJet")) {
                    aircraft = new PrivateJet(aircraftModel, 20, 7500, true, 800);
                } else {
                    throw new IllegalArgumentException("Unknown aircraft type: " + aircraftType);
                }

                // Create passenger if
                if (!passengerName.equalsIgnoreCase("None")) {
                    Passenger passenger = new Passenger(passengerName, passportNumber);

                    // Add to reservation map with good passenger data
                    result.putIfAbsent(flightNumber, new ArrayList<>());
                    result.get(flightNumber).add(passenger);
                    continue;
                }
                // with "None" as passenger name
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



}
