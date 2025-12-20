import java.util.Scanner;

public class GradeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input marks of physics, chem and maths
        System.out.print("Enter Physics marks: ");
        double physics = sc.nextDouble();
        System.out.print("Enter Chemistry marks: ");
        double chemistry = sc.nextDouble();
        System.out.print("Enter Maths marks: ");
        double maths = sc.nextDouble();

        // Calculate percentage of all
        double percentage = (physics + chemistry + maths) / 3;

        System.out.println("Percentage: " + percentage);

        // Grade logic for the calculation
        if (percentage >= 80)
            System.out.println("Grade A");
        else if (percentage >= 70)
            System.out.println("Grade B");
        else if (percentage >= 60)
            System.out.println("Grade C");
        else if (percentage >= 50)
            System.out.println("Grade D");
        else if (percentage >= 40)
            System.out.println("Grade E");
        else
            System.out.println("Grade R (Remedial)");
    }
}