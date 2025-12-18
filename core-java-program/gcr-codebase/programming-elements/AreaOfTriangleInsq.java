import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double b = sc.nextDouble();
        double h = sc.nextDouble();

        double areaCm = (b * h) / 2;
        double areaIn = areaCm / (2.54 * 2.54);

        System.out.println(
            "The Area of the triangle in sq in is " + areaIn + " and sq cm is " + areaCm
        );
    }
}
