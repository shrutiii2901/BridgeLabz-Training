import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        // take input date
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Date (yyyy-mm-dd):");
        String input = scanner.nextLine();
        // convert date 
        LocalDate date = LocalDate.parse(input);

        LocalDate result = date.plusDays(7)
                               .plusMonths(1)
                               .plusYears(2)
                               .minusWeeks(3);
        // display result

        System.out.println("After calculation fainal date is " + result);


    }
}
 