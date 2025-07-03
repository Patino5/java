package airport.domain.model;

public abstract class Aircraft {
    protected String model;
    protected int capacity;
    protected int fuelCapacity;

    public Aircraft(String model, int capacity, int fuelCapacity) {
        this.model = model;
        this.capacity = capacity;
        this.fuelCapacity = fuelCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public abstract String getAircraftType();
}
