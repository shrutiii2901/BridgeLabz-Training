public class Trigonometry {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radian = Math.toRadians(angle);
        return new double[]{
            Math.sin(radian),
            Math.cos(radian),
            Math.tan(radian)
        };
    }

    public static void main(String[] args) {
        double angle = Double.parseDouble(args[0]);

        double[] result = calculateTrigonometricFunctions(angle);
        System.out.println("Sin: " + result[0]);
        System.out.println("Cos: " + result[1]);
        System.out.println("Tan: " + result[2]);
    }
}
