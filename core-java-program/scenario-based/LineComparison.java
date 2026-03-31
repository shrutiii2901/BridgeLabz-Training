import java.util.Scanner;

public class LineComparison {

    // calculate length of a line
    public static double calculateLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // check equality of two lengths
    public static boolean checkEquality(double length1, double length2) {
        return Double.compare(length1, length2) == 0;
    }

    // compare two lengths of two lines
    public static int compareLengths(double length1, double length2) {
        return Double.compare(length1, length2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input for Line 1
        System.out.println("Enter coordinates for Line 1:");
        System.out.print("x1: ");
        int x1 = sc.nextInt();
        System.out.print("y1: ");
        int y1 = sc.nextInt();
        System.out.print("x2: ");
        int x2 = sc.nextInt();
        System.out.print("y2: ");
        int y2 = sc.nextInt();

        // input for Line 2
        System.out.println("\nEnter coordinates for Line 2:");
        System.out.print("x3: ");
        int x3 = sc.nextInt();
        System.out.print("y3: ");
        int y3 = sc.nextInt();
        System.out.print("x4: ");
        int x4 = sc.nextInt();
        System.out.print("y4: ");
        int y4 = sc.nextInt();

        // calculate lengths
        double length1 = calculateLength(x1, y1, x2, y2);
        double length2 = calculateLength(x3, y3, x4, y4);

        System.out.println("\nLength of Line 1: " + length1);
        System.out.println("Length of Line 2: " + length2);

        // equality check
        if (checkEquality(length1, length2)) {
            System.out.println("Both lines are equal");
        } else {
            System.out.println("Lines are not equal");
        }

        // comparison
        int result = compareLengths(length1, length2);

        if (result == 0) {
            System.out.println("Both lines are equal in length");
        } else if (result > 0) {
            System.out.println("Line 1 is greater than Line 2");
        } else {
            System.out.println("Line 1 is smaller than Line 2");
        }

        sc.close();
    }
}
