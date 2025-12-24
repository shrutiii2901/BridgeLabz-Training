import java.util.Scanner;

public class EasyCoffeeCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter gst");
        double gst = scanner.nextDouble();   
        while (true) {

            
            System.out.println("\nEnter coffee type (coffee / tea) or type exit:");
            String coffeeType = scanner.next();

            
            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Thank you! Cafe closed.");
                break;
            }

            
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            int price = 0;

            
            switch (coffeeType.toLowerCase()) {
                case "Ameicano":
                    price = 50;
                    break;
                case "Espresso":
                    price = 30;
                    break;
                default:
                    System.out.println("Invalid coffee type");
                    continue;
            }

            
            int totalBill = price * quantity;

            
            double gstAmount = totalBill * gst;

          
            double finalAmount = totalBill + gstAmount;

            
            System.out.println("Total Amount (without GST): Rs." + totalBill);
            System.out.println("GST Amount: Rs." + gstAmount);
            System.out.println("Final Amount to Pay: Rs." + finalAmount);
        }
    }
}