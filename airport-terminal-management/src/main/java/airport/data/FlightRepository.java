package airport.data;

import airport.domain.model.Flight;

import java.util.ArrayList;

public interface FlightRepository {
    ArrayList<Flight> getFlights();
}
