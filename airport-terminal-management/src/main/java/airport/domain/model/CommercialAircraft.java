package airport.domain.model;

public class CommercialAircraft extends Aircraft {
    private final String airlineName;

    public CommercialAircraft(String model, int capacity, int fuelCapacity, String airlineName) {
        super(model, capacity, fuelCapacity);
        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAircraftType() {
        return "Commercial";
    }
}
