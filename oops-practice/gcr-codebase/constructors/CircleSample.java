class CircleSample {
    double radius;

    CircleSample() {
        this(1.0); // constructor chaining
    }

    CircleSample(double r) {
        radius = r;
    }

    void area() {
        System.out.println("Area = " + (3.14 * radius * radius));
    }

    public static void main(String[] args) {
        CircleSample c1 = new CircleSample();
        CircleSample c2 = new CircleSample(5);
        c1.area();
        c2.area();
    }
}
