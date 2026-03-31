import java.util.Scanner;

public class FactorialRecursion {
    // method for factorial

    static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        // call method

        System.out.println("Factorial = " + factorial(n));
    }
}