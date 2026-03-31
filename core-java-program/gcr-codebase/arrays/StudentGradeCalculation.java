
import java.util.Scanner;

public class StudentGradeCalculation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Arrays to store marks, percentage and grade
        int[] physicsMarks = new int[numberOfStudents];
        int[] chemistryMarks = new int[numberOfStudents];
        int[] mathsMarks = new int[numberOfStudents];
        double[] percentage = new double[numberOfStudents];
        char[] grade = new char[numberOfStudents];

        // Loop to take marks input
        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("\nEnter marks for Student " + (i + 1));

            // Physics marks
            System.out.print("Physics: ");
            physicsMarks[i] = scanner.nextInt();
            if (physicsMarks[i] < 0) {
                i--;
                System.out.println("Marks cannot be negative. Re-enter student details.");
                continue;
            }

            // Chemistry marks
            System.out.print("Chemistry: ");
            chemistryMarks[i] = scanner.nextInt();

            // Maths marks
            System.out.print("Maths: ");
            mathsMarks[i] = scanner.nextInt();

            // Calculate percentage
            percentage[i] = (physicsMarks[i] + chemistryMarks[i] + mathsMarks[i]) / 3.0;

            // Calculate grade
            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        // print results
        System.out.println("\nStudent Results:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) +
                    " | Percentage: " + percentage[i] +
                    " | Grade: " + grade[i]);
        }
    }
}
