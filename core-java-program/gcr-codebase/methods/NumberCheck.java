import java.util.Scanner;

public class NumberCheck {
    public static int checkNumber(int num) {
        if (num > 0) return 1;
        if (num < 0) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println(checkNumber(number));
    }
}
