import java.util.Scanner;

class Circle {

    double radius;

    void calculateArea() {
        double area = 3.1415 * radius * radius;
        System.out.printf("Area of circle: %.4f\n", area);
    }

    void calculateCircumference() {
        double circumference = 2 * 3.1415 * radius;
        System.out.printf("Circumference of circle: %.4f\n", circumference);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Circle c = new Circle();

        System.out.print("Enter radius of circle: ");
        c.radius = sc.nextDouble();

        c.calculateArea();
        c.calculateCircumference();

        sc.close();
    }
}
