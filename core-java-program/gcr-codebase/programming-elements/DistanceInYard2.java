import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double feetVal = sc.nextDouble();

        double yardVal = feetVal / 3;
        double mileVal = yardVal / 1760;

        System.out.println(
            "The distance in yards is " + yardVal + " while the distance in miles is " + mileVal
        );
    }
}
