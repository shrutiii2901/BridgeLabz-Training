import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int originalNumber = number;
        int sum = 0;

        
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number = number / 10;
        }

        // Check Armstrong or not
        if (sum == originalNumber)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not an Armstrong Number");
    }
}