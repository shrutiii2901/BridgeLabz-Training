import java.util.*;

interface Refuelable{
    void refuel();
}

class Vehicle{
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model){
        this.maxSpeed= maxSpeed;
        this.model= model;
    }
}

class ElectricVehicle extends Vehicle {
    
    ElectricVehicle(int maxSpeed, String model){
        super(maxSpeed, model);
    }

    public void charge(){
        System.out.println(model+"is charging.");
    }
    
}
class PetrolVehicle extends Vehicle  implements Refuelable{
    
    PetrolVehicle(int maxSpeed, String model){
        super(maxSpeed, model);
    }

    @Override
    public void refuel(){
      System.out.println(model + "is refueling with pertrol");
    }
}


public class VehicleTest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.print("Enter Model Name: ");
        String model = sc.nextLine();

        System.out.print("Enter Max Speed: ");
        int speed = sc.nextInt();

        PetrolVehicle p = new PetrolVehicle(speed, model);
        p.refuel();
    }
}