import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking year input
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        // Check Gregorian calendar condition
        if (year >= 1582) {
            // Leap year logic
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println("Leap Year");
            } else {
                System.out.println("Not a Leap Year");
            }
        } else {
            System.out.println("Year should be 1582 or later");
        }
    }
}