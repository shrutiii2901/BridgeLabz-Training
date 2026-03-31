import java.util.Scanner;

public class BasicCalculator {
    // method to add

    static int add(int a, int b) { return a + b; }
    // method to subtract
    static int subtract(int a, int b) { return a - b; }
    // method to multiply
    static int multiply(int a, int b) { return a * b; }
    // method to divide
    static double divide(int a, int b) { return (double) a / b; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("1.Add 2.Subtract 3.Multiply 4.Divide");
        System.out.print("Choose operation: ");
        int choice = sc.nextInt();
        // use switch for getting results

        switch (choice) {
            case 1 -> System.out.println("Result = " + add(a, b));
            case 2 -> System.out.println("Result = " + subtract(a, b));
            case 3 -> System.out.println("Result = " + multiply(a, b));
            case 4 -> System.out.println("Result = " + divide(a, b));
            default -> System.out.println("Invalid choice");
        }
    }
}