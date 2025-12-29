import java.util.Scanner;

public class MaximumOfThreeNumber {

    static int findMax(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void main(String[] args) {
        // take input three numbers
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        System.out.println("Maximum number is: " + findMax(num1, num2, num3));
    }
}