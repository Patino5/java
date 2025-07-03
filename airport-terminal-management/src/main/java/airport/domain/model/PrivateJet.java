package airport.domain.model;

public class PrivateJet extends  Aircraft {
    private final boolean hasLuxuryService;
    private final int maxSpeed;

    public PrivateJet(String model, int capacity, int fuelCapacity, boolean hasLuxuryService, int maxSpeed) {
        super(model, capacity, fuelCapacity);
        this.hasLuxuryService = hasLuxuryService;
        this.maxSpeed = maxSpeed;
    }

    public boolean isHasLuxuryService() {
        return hasLuxuryService;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getAircraftType() {
        return "PrivateJet";
    }
}
