import java.util.Scanner;

class MobilePhone {

    String brand;
    String model;
    double price;

    void displayDetails() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
    
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MobilePhone m = new MobilePhone();

        System.out.print("Enter Mobile Brand: ");
        m.brand = sc.nextLine();

        System.out.print("Enter Mobile Model: ");
        m.model = sc.nextLine();

        System.out.print("Enter Mobile Price: ");
        m.price = sc.nextDouble();

        System.out.println("\nEntered Mobile Details:");
        m.displayDetails();

        sc.close();
    }
}
