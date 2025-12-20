import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // person data
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input height and weight
        for (int i = 0; i < number; i++) {

            System.out.print("Enter height: ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Enter weight: ");
            personData[i][1] = sc.nextDouble();

            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Invalid input. Enter again.");
                i--;
            }
        }

        // Calculate BMI and status
        for (int i = 0; i < number; i++) {
            personData[i][2] =
                personData[i][1] / (personData[i][0] * personData[i][0]);

            double bmi = personData[i][2];

            if (bmi <= 18.4)
                weightStatus[i] = "Underweight";
            else if (bmi <= 24.9)
                weightStatus[i] = "Normal";
            else if (bmi <= 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        // print result
        for (int i = 0; i < number; i++) {
            System.out.println("Height: " + personData[i][0] +
                               " Weight: " + personData[i][1] +
                               " BMI: " + personData[i][2] +
                               " Status: " + weightStatus[i]);
        }
    }
}
