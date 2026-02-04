interface RentalVehicle {
    void rent();
    void returnVehicle();
}

class Car implements RentalVehicle {
    public void rent() {
        System.out.println("Car rented");
    }
    public void returnVehicle() {
        System.out.println("Car returned");
    }
}

class Bike implements RentalVehicle {
    public void rent() {
        System.out.println("Bike rented");
    }
    public void returnVehicle() {
        System.out.println("Bike returned");
    }
}

class Bus implements RentalVehicle {
    public void rent() {
        System.out.println("Bus rented");
    }
    public void returnVehicle() {
        System.out.println("Bus returned");
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        RentalVehicle v1 = new Car();
        RentalVehicle v2 = new Bike();
        RentalVehicle v3 = new Bus();

        v1.rent(); v1.returnVehicle();
        v2.rent(); v2.returnVehicle();
        v3.rent(); v3.returnVehicle();
    }
}
