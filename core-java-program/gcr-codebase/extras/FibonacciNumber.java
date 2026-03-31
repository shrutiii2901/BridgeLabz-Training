import java.util.Scanner;

public class FibonacciNumber {
    // method to print fibonacci

    static void printFibonacci(int n) {
        int a = 0, b = 1;
        // initialize the loop for iteration 

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        // call the method to print 

        printFibonacci(n);
    }
}