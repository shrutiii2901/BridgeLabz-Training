import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class RohanLibrary {

    public static void main(String[] args) {
        // take input

        Scanner sc = new Scanner(System.in);
        long totalFine = 0;
        // initialize the loop 

        for (int i = 1; i <= 5; i++) {

            System.out.println("Book " + i);
            // due date 
            System.out.print("Enter Due Date (yyyy-mm-dd): ");
            LocalDate dueDate = LocalDate.parse(sc.next());
            // return date
            System.out.print("Enter Return Date (yyyy-mm-dd): ");
            LocalDate returnDate = LocalDate.parse(sc.next());
            // check condition

            if (returnDate.isAfter(dueDate)) {
                long lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);
                long fine = lateDays * 5;
                System.out.println("Late by " + lateDays + " days. Fine = Rs." + fine);
                totalFine += fine;
            } else {
                System.out.println("Returned on time. No fine.");
            }
        }

        System.out.println("Total Fine for all books = Rs." + totalFine);
    }
}