import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Arrays to store salary and years of service
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];

        // Arrays to store bonus and new salary
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Taking input for 10 employees
        for (int i = 0; i < 10; i++) {

            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Salary: ");
            salary[i] = sc.nextDouble();

            System.out.print("Years of Service: ");
            yearsOfService[i] = sc.nextDouble();
            if (salary[i] <= 0 || yearsOfService[i] < 0) {
                System.out.println("Invalid input. Enter again.");
                i--; 
                continue;
            }
        }

        for (int i = 0; i < 10; i++) {
            //5% bonus

            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05; 
            } 
            // 2% bonus
            else {
                bonus[i] = salary[i] * 0.02; 
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // print totals
        System.out.println("Total Bonus Paid = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total New Salary = " + totalNewSalary);
    }
}