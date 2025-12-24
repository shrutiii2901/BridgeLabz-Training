import java.util.Scanner;

public class TriangularPark {
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1: ");
        double s1 = sc.nextDouble();
        System.out.print("Enter side 2: ");
        double s2 = sc.nextDouble();
        System.out.print("Enter side 3: ");
        double s3 = sc.nextDouble();

        System.out.println("Rounds needed: " +
                calculateRounds(s1, s2, s3));
    }
}
