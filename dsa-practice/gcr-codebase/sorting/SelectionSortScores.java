import java.util.Arrays;

public class SelectionSortScores {

    public static void selectionSort(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {67, 89, 45, 72, 90};
        selectionSort(scores);
        System.out.println("Sorted Exam Scores: " + Arrays.toString(scores));
    }
}
