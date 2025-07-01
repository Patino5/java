package airport.domain.model;

public class PrivateJet extends Aircraft {
    private final boolean hasLuxuryService; // true if lux service available
    private final int maxSpeed; // jet speed in km/h

    public PrivateJet(String model, int capacity, double fuelCapacity,boolean hasLuxuryService, int maxSpeed) {
        super(model, capacity, fuelCapacity);
        this.hasLuxuryService = hasLuxuryService;
        this.maxSpeed = maxSpeed;
    }

    public boolean hasLuxuryService() {
        return hasLuxuryService;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getAircraftType() {
        return "Commercial";
    }
}
