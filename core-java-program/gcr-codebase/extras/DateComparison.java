import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        // take input

        Scanner sc = new Scanner(System.in);
        // take first date

        System.out.print("Enter first date (yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());
        //take second date

        System.out.print("Enter second date (yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());
        // check condition and print

        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER second date");
        } else {
            System.out.println("Both dates are SAME");
        }
    }
}