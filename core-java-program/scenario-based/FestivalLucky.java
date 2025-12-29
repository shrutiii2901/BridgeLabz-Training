import java.util.Scanner;

public class FestivalLucky {

    public static void main(String[] args) {
        // take input

        Scanner scanner = new Scanner(System.in);
        int luckyNumber;

        while (true) {

            System.out.print("Enter your lucky number (Enter -1 to exit): ");
            luckyNumber = scanner.nextInt();

            // Exit condition
            if (luckyNumber == -1) {
                break;
            }

            // Invalid input
            if (luckyNumber <= 0) {
                System.out.println("Invalid number. Try again.");
                continue;
            }

            // Lucky draw condition
            if (luckyNumber % 3 == 0 && luckyNumber % 5 == 0) {
                System.out.println("Congratulations! You won a gift ");
            } else {
                System.out.println("Sorry, better luck next time.");
            }
        }

        System.out.println("Thank you for visiting the Diwali Mela ");
        
    }
}