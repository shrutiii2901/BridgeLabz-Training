import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int op1 = x + y * z;
        int op2 = x * y + z;
        int op3 = z + x / y;
        int op4 = x % y + z;

        System.out.println(
            "The results of Int Operations are " +
            op1 + ", " + op2 + ", " + op3 + ", and " + op4
        );
    }
}
