import java.util.Scanner;

public class PrimeNumberChecker {
    // method to check prime number

    static boolean isPrime(int n) {
        // check condition
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isPrime(n))
            System.out.println("Prime Number");
        else
            System.out.println("Not a Prime Number");
    }
}