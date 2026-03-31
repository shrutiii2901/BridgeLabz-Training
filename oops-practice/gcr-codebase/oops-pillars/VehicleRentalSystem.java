import java.util.ArrayList;
import java.util.List;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {

    
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber; 

  
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    
    public abstract double calculateRentalCost(int days);

    
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    
    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

   
    public void displayVehicleDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + type);
        System.out.println("Rental Rate    : " + rentalRate + " per day");
    }
}

class Car extends Vehicle implements Insurable {

    public Car(String number, double rate, String policyNo) {
        super(number, "Car", rate, policyNo);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (Policy No: " + getInsurancePolicyNumber() + ")";
    }
}

class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate, String policyNo) {
        super(number, "Bike", rate, policyNo);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) * 0.9; 
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (Policy No: " + getInsurancePolicyNumber() + ")";
    }
}

class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate, String policyNo) {
        super(number, "Truck", rate, policyNo);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 2000; 
    }

    @Override
    public double calculateInsurance() {
        return 1500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (Policy No: " + getInsurancePolicyNumber() + ")";
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", 2000, "CAR-INS-111"));
        vehicles.add(new Bike("BIKE202", 800, "BIKE-INS-222"));
        vehicles.add(new Truck("TRUCK303", 5000, "TRUCK-INS-333"));

        int rentalDays = 5;

        
        for (Vehicle v : vehicles) {

            v.displayVehicleDetails();

            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = 0;

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                insuranceCost = ins.calculateInsurance();
                System.out.println(ins.getInsuranceDetails());
            }

            System.out.println("Rental Days   : " + rentalDays);
            System.out.println("Rental Cost  : " + rentalCost);
            System.out.println("Insurance    : " + insuranceCost);
            System.out.println("Total Cost   : " + (rentalCost + insuranceCost));
        }
    }
}