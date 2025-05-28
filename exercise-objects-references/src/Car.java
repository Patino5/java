public class Car {
    private String make;
    private  String model;
    private int year;

    public Car(String make, String model, int year) { // constructor
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // method car can call with dot notation
    public void displayInfo() {
        System.out.println("Make: " + make + "\nModel: " + model + "\nYear: " + year);
    }

    // Getters and Setters: used to access the values in respective variables
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }


}
