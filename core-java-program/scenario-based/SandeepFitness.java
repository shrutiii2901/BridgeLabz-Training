import java.util.Scanner;

public class SandeepFitness {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] pushUps = new int[7];

        System.out.println("Enter push-ups for 7 days (enter 0 for rest day):");

        // Taking input for array
        for (int i = 0; i < pushUps.length; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            pushUps[i] = sc.nextInt();
        }

        int total = 0;
        int activeDays = 0;

        // for-each loop
        for (int dailyCount : pushUps) {

            // Skip rest days
            if (dailyCount == 0) {
                continue;
            }

            total += dailyCount;
            activeDays++;
        }

        double average = (double) total / activeDays;

        System.out.println("Total push-ups in the week: " + total);
        System.out.println("Average push-ups per active day: " + average);
    }
}