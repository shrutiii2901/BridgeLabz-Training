import java.util.Scanner;

class BMICalculator {

    // Method to calculate BMI value
    static double calculateBMI(double weightKg, double heightCm) {
        double heightMeter = heightCm / 100;   // Convert cm to meter
        return weightKg / (heightMeter * heightMeter);
    }

    // Method to determine BMI Status
    static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Method to compute BMI and Status for all persons
    static String[][] computeBMI(double[][] data) {

        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];

            double bmi = calculateBMI(weight, height);
            String status = getBMIStatus(bmi);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }

    // Method to display result in tabular format
    static void displayResult(String[][] result) {
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("-----------------------------------------------------");

        for (String[] row : result) {
            System.out.println(
                    row[0] + "\t\t" +
                    row[1] + "\t\t" +
                    row[2] + "\t" +
                    row[3]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 2D array to store weight and height of 10 members
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));
            System.out.print("Enter Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = computeBMI(data);
        displayResult(result);
    }
}
