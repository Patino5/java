package airport.data;

import airport.domain.model.Aircraft;
import airport.domain.model.CommercialAircraft;
import airport.domain.model.Flight;
import airport.domain.model.PrivateJet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class SampleFlightRepository implements  FlightRepository {

    @Override
    public ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<>();

        // Private Jets
        Aircraft jet1 = new PrivateJet("Gulfstream G650", 18, 7000, true, 850);
        Aircraft jet2 = new PrivateJet("Bombardier Global 7500", 17, 7700, true, 870);
        Aircraft jet3 = new PrivateJet("Cessna Citation X+", 12, 3460, true, 717);
        Aircraft jet4 = new PrivateJet("Dassault Falcon 8X", 16, 6450, true, 780);

        // Commercial Aircraft
        Aircraft commercial1 = new CommercialAircraft("Boeing 737-800", 189, 3115, "Trailblazer");
        Aircraft commercial2 = new CommercialAircraft("Airbus A320", 180, 3300, "BigAir");
        Aircraft commercial3 = new CommercialAircraft("Boeing 777-300ER", 396, 7370, "Ryanair");
        Aircraft commercial4 = new CommercialAircraft("Airbus A350-900", 325, 8100, "SkyLiner");

        // Flight listings
        flights.add(new Flight("FL001", LocalDate.now().plusDays(2), new BigDecimal("14999.99"), jet1));
        flights.add(new Flight("FL002", LocalDate.now().plusDays(5), new BigDecimal("13500.00"), jet2));
        flights.add(new Flight("FL003", LocalDate.now().plusDays(3), new BigDecimal("18999.99"), jet3));
        flights.add(new Flight("FL004", LocalDate.now().plusDays(7), new BigDecimal("22500.00"), jet4));
        flights.add(new Flight("FL005", LocalDate.now().plusDays(1), new BigDecimal("450.00"), commercial1));
        flights.add(new Flight("FL006", LocalDate.now().plusDays(4), new BigDecimal("380.00"), commercial2));
        flights.add(new Flight("FL007", LocalDate.now().plusDays(6), new BigDecimal("1200.00"), commercial3));
        flights.add(new Flight("FL008", LocalDate.now().plusDays(8), new BigDecimal("950.00"), commercial4));

        return flights;
    }
}
