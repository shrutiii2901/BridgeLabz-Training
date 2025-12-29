import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    // define method for guessing

    static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }
    // method for user feedback

    static String feedback(Scanner sc) {
        System.out.print("Is the guess High, Low or Correct? ");
        return sc.next().toLowerCase();
    }
    // main function

    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);
        // initialize low , high and feedback
        int low = 1, high = 100;
        String feedback;

        System.out.println("Think of a number between 1 and 100.");
        // define while loop 
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Computer guesses: " + guess);

            feedback = feedback(sc);

            if (feedback.equals("correct")) {
                System.out.println("Computer guessed correctly!");
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }
    }
}