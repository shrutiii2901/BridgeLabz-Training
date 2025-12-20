import java.util.Scanner;

public class BMIArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[] height = new double[number];
        double[] weight = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        // Input height and weight
        for (int i = 0; i < number; i++) {
            System.out.print("Enter height (meters): ");
            height[i] = sc.nextDouble();

            System.out.print("Enter weight (kg): ");
            weight[i] = sc.nextDouble();

            if (height[i] <= 0 || weight[i] <= 0) {
                System.out.println("Invalid input. Enter again.");
                i--;
            }
        }

        // Calculate BMI and status
        for (int i = 0; i < number; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4)
                status[i] = "Underweight";
            else if (bmi[i] <= 24.9)
                status[i] = "Normal";
            else if (bmi[i] <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        // print result
        for (int i = 0; i < number; i++) {
            System.out.println("Height: " + height[i] +
                               " Weight: " + weight[i] +
                               " BMI: " + bmi[i] +
                               " Status: " + status[i]);
        }
    }
}
