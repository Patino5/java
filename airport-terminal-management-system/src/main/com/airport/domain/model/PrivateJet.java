package airport.domain.model;

public class PrivateJet extends Aircraft {
    private boolean hasLuxuryService; // true if lux service available
    private int maxSpeed; // jet speed in km/h

    public PrivateJet(String model, int capacity, double fuelCapacity) {
        super(model, capacity, fuelCapacity);
    }
}
