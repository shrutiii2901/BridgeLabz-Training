import java.util.Scanner;

class CarRental {

    
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    
    CarRental() {
        customerName = "Not Assigned";
        carModel = "Not Selected";
        rentalDays = 0;
        totalCost = 0;
    }

    
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateTotalCost();
    }

    
    void calculateTotalCost() {
        double rentPerDay = 1500.0;
        totalCost = rentalDays * rentPerDay;
    }

    
    void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + totalCost);
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       
        System.out.println("Enter customer name:");
        String name = sc.nextLine();

        System.out.println("Enter car model:");
        String model = sc.nextLine();

        System.out.println("Enter number of rental days:");
        int days = sc.nextInt();

        
        CarRental rental = new CarRental(name, model, days);

        
        System.out.println("\nCar Rental Details:");
        rental.displayDetails();

    }
}