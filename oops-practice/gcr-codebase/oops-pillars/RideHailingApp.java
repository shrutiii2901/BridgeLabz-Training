// RideHailingApp.java
abstract class RideVehicle {
    protected String driverName;
    protected double ratePerKm;

    public RideVehicle(String driver, double rate) {
        this.driverName = driver;
        this.ratePerKm = rate;
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
}

class CarRide extends RideVehicle implements GPS {
    public CarRide(String driver, double rate) {
        super(driver, rate);
    }

    public double calculateFare(double distance) {
        return ratePerKm * distance;
    }

    public String getCurrentLocation() {
        return "MG Road";
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        RideVehicle ride = new CarRide("Anil", 15);
        System.out.println("Fare: " + ride.calculateFare(10));
    }
}
