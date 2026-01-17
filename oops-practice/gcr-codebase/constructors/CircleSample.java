import java.util.Scanner;

class CircleSample {
    double radius;

    CircleSample() {
        this(1.0);   //constructor chaining
    }

    CircleSample(double r) {
        radius = r;
    }

    void area() {
        System.out.println("Area = " + (3.14 * radius * radius));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius for first circle: ");
        double r1 = sc.nextDouble();

        System.out.print("Enter radius for second circle: ");
        double r2 = sc.nextDouble();

        CircleSample c1 = new CircleSample(r1);
        CircleSample c2 = new CircleSample(r2);

        c1.area();
        c2.area();

        sc.close();
    }
}
