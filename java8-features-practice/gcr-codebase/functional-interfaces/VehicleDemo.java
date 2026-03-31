interface Vehicle {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery not available");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Speed: 80 km/h");
    }

    public void displayBattery() {
        System.out.println("Battery: 75%");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v = new ElectricCar();
        v.displaySpeed();
        v.displayBattery();
    }
}
