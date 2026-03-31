import java.util.Scanner;

public class StudentGrade2DArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();

        // 2D array to store marks (Physics, Chemistry, Maths)
        int[][] marks = new int[students][3];
        double[] percentage = new double[students];
        char[] grade = new char[students];

        // Input marks
        for (int i = 0; i < students; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            for (int j = 0; j < 3; j++) {
                marks[i][j] = scanner.nextInt();

                // Validate marks
                if (marks[i][j] < 0) {
                    System.out.println("Marks cannot be negative. Re-enter student details.");
                    i--;
                    break;
                }
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < students; i++) {
            int total = 0;

            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }

            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) grade[i] = 'A';
            else if (percentage[i] >= 70) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 50) grade[i] = 'D';
            else if (percentage[i] >= 40) grade[i] = 'E';
            else grade[i] = 'R';
        }

        // print output
        System.out.println("\nStudent Results:");
        for (int i = 0; i < students; i++) {
            System.out.println("Student " + (i + 1) +
                    " | Percentage: " + percentage[i] +
                    " | Grade: " + grade[i]);
        }
    }
}
