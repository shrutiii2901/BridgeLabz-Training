import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();

        double op1 = x + y * z;
        double op2 = x * y + z;
        double op3 = z + x / y;
        double op4 = x % y + z;

        System.out.println(
            "The results of Double Operations are " +
            op1 + ", " + op2 + ", " + op3 + ", and " + op4
        );
    }
}
