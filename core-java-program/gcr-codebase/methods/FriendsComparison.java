import java.util.Scanner;

public class FriendsComparison {

    public static int findYoungest(int[] ages) {
        int min = ages[0];
        for (int a : ages) min = Math.min(min, a);
        return min;
    }

    public static double findTallest(double[] heights) {
        double max = heights[0];
        for (double h : heights) max = Math.max(max, h);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age: ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height: ");
            heights[i] = sc.nextDouble();
        }

        System.out.println("Youngest Age: " + findYoungest(ages));
        System.out.println("Tallest Height: " + findTallest(heights));
    }
}

