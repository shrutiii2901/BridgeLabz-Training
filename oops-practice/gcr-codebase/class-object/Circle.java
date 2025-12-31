// Circle class
class Circle {


    double radius;

    // method to calculate 
    void calculateArea() {
        double area = 3.1415 * radius * radius;
        System.out.printf("Area of circle: %.4f\n", area);
    }

    // method to calculate and display circumference
    void calculateCircumference() {
        double circumference = 2 * 3.1415 * radius;
        System.out.printf("Circumference of circle: %.4f\n", circumference);
    }

    // main method hai 
    public static void main(String[] args) {

        Circle c = new Circle();

        // given radius
        c.radius = 2.5;

        
        c.calculateArea();
        c.calculateCircumference();
    }
}