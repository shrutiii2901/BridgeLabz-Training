import java.util.Scanner;

public class GCDLCM {
    // method of gcd

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    // method of lcm

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        // call and print gcd and lcm

        System.out.println("GCD = " + gcd(a, b));
        System.out.println("LCM = " + lcm(a, b));
    }
}