import java.util.Random;
import java.util.Scanner;

public class EmployeeWages {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Employee Wage Computation Program");

        // Constants
        int WAGE_PER_HOUR = 20;
        int FULL_DAY_HOUR = 8;
        int PART_TIME_HOUR = 4;
        int WORKING_DAYS = 20;
        int MAX_WORKING_HOURS = 100;

        /* UC 1 
           User enters 1 or 0 to check attendance
           Random decides if employee is actually present
        */
        System.out.print("Enter 1 to check employee attendance or 0 to skip: ");
        int userInput = sc.nextInt();

        int attendance;
        if (userInput == 1) {
            attendance = random.nextInt(2); // 0 = Absent, 1 = Present
        } else {
            attendance = 0; // User chose to skip
        }

        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }

        /*  UC 2 
           Calculate Daily Employee Wage
        */
        int dailyWage = attendance * FULL_DAY_HOUR * WAGE_PER_HOUR;
        System.out.println("Daily Employee Wage: " + dailyWage);

        /*  UC 3 & UC 4 
           Part Time / Full Time using Switch Case
           User input
        */
        System.out.print("Enter Employee Type (1-Full Time, 2-Part Time, 0-Absent): ");
        int empType = sc.nextInt();

        int empHours = 0;

        switch (empType) {
            case 1:
                empHours = FULL_DAY_HOUR;
                System.out.println("Employee is Full Time");
                break;
            case 2:
                empHours = PART_TIME_HOUR;
                System.out.println("Employee is Part Time");
                break;
            default:
                empHours = 0;
                System.out.println("Employee is Absent");
        }

        int empWage = empHours * WAGE_PER_HOUR;
        System.out.println("Employee Wage: " + empWage);

        /* UC 5 
           Monthly Wage (20 Working Days)
           User enters hours per day
        */
        int totalMonthlyWage = 0;

        for (int day = 1; day <= WORKING_DAYS; day++) {
            System.out.print("Enter working hours for Day " + day + " (0 / 4 / 8): ");
            int hours = sc.nextInt();
            totalMonthlyWage += hours * WAGE_PER_HOUR;
        }

        System.out.println("Total Monthly Wage (20 Days): " + totalMonthlyWage);

        /*  UC 6 
           Wage till 100 hours or 20 days
           User enters hours per day until condition is met
        */
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < MAX_WORKING_HOURS && totalDays < WORKING_DAYS) {
            System.out.print("Enter working hours for Day " + (totalDays + 1) + " (0 / 4 / 8): ");
            int hours = sc.nextInt();

            totalHours += hours;
            totalWage += hours * WAGE_PER_HOUR;
            totalDays++;
        }

        System.out.println("Total Working Days: " + totalDays);
        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Wage till Condition Reached: " + totalWage);

        System.out.println("Thank You");
        sc.close();
    }
}