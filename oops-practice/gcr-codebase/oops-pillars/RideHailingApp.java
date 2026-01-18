interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {

    
    private int vehicleId;
    private String driverName;
    protected double ratePerKm;

    Vehicle(int id, String driver, double rate) {
        this.vehicleId = id;
        this.driverName = driver;
        this.ratePerKm = rate;
    }

    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName);
    }

    
    abstract double calculateFare(double distance);
}

class Car extends Vehicle implements GPS {

    private String location = "Not Set";

    Car(int id, String driver) {
        super(id, driver, 15);
    }

    double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

class Bike extends Vehicle implements GPS {

    private String location = "Not Set";

    Bike(int id, String driver) {
        super(id, driver, 8);
    }

    double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

class Auto extends Vehicle implements GPS {

    private String location = "Not Set";

    Auto(int id, String driver) {
        super(id, driver, 10);
    }

    double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

public class RideHailingApp {

    
    static void calculateRide(Vehicle v, double distance) {
        v.getVehicleDetails();
        System.out.println("Fare: ₹" + v.calculateFare(distance));
    }

    public static void main(String[] args) {

        Vehicle v1 = new Car(101, "Ravi");
        Vehicle v2 = new Bike(102, "Amit");
        Vehicle v3 = new Auto(103, "Suresh");

        calculateRide(v1, 10);
        calculateRide(v2, 10);
        calculateRide(v3, 10);
    }
}