import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        double y = sc.nextDouble();

        System.out.println(
            "The addition, subtraction, multiplication, and division value of 2 numbers "
            + x + " and " + y + " is "
            + (x + y) + ", " + (x - y) + ", " + (x * y) + ", and " + (x / y)
        );
    }
}
