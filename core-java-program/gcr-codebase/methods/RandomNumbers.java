import java.util.Random;

public class RandomNumbers {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + rand.nextInt(9000);
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;

        for (int n : numbers) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return new double[]{(double) sum / numbers.length, min, max};
    }

    public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);
        double[] result = findAverageMinMax(arr);

        System.out.println("Average: " + result[0]);
        System.out.println("Min: " + result[1]);
        System.out.println("Max: " + result[2]);
    }
}
