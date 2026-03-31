import java.util.Scanner;

public class HarshadNumberOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int original = number;
        int sum = 0;

        // Calculate sum of digits
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        // Check Harshad or Not
        if (original % sum == 0)
            System.out.println("Harshad Number");
        else
            System.out.println("Not a Harshad Number");
    }
}