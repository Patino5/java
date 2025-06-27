package airport.domain.model;

public class PrivateJet extends Aircraft {
    private boolean hasLuxuryService; // true if lux service available
    private int maxSpeed; // jet speed in km/h

    public PrivateJet(String model, int capacity, double fuelCapacity,boolean hasLuxuryService, int maxSpeed) {
        super(model, capacity, fuelCapacity);
        this.hasLuxuryService = hasLuxuryService;
        this.maxSpeed = maxSpeed;
    }
}
