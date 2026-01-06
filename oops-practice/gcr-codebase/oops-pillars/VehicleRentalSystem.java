// VehicleRentalSystem.java
import java.util.*;

abstract class Vehicle {
    private String vehicleNumber;
    protected double rentalRate;

    public Vehicle(String number, double rate) {
        this.vehicleNumber = number;
        this.rentalRate = rate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String number, double rate) {
        super(number, rate);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Car Insurance";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("MH12AB1234", 2000));

        for (Vehicle v : vehicles) {
            System.out.println("Rental: " + v.calculateRentalCost(3));
        }
    }
}
