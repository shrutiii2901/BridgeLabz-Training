import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take input number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int temp = number;
        int count = 0;

        // Count digits
        while (temp != 0) {
            count++;
            temp /= 10;
        }
        int[] digits = new int[count];
        temp = number;

        // Store digits in array
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        int[] frequency = new int[10];

        // Calculate frequency
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        // print frequency
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " times");
            }
        }
    }
}
