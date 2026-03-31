import java.util.Scanner;

public class SideSquare2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double p = sc.nextDouble();
        double sideLength = p / 4;

        System.out.println(
            "The length of the side is " + sideLength + " whose perimeter is " + p
        );
    }
}
