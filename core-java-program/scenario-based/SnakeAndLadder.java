import java.util.Random;

public class SnakeAndLadder {

    public static void main(String[] args) {

        Random random = new Random();

        int player1Pos = 0;
        int player2Pos = 0;

        int diceCount1 = 0;
        int diceCount2 = 0;

        boolean isPlayer1Turn = true;

        while (player1Pos < 100 && player2Pos < 100) {

            int dice = random.nextInt(6) + 1; // UC 1
            int option = random.nextInt(3);  // 0 = No Play, 1 = Ladder, 2 = Snake

            if (isPlayer1Turn) {
                diceCount1++;
                System.out.println("\nPlayer 1 rolled: " + dice);

                player1Pos = movePlayer(player1Pos, dice, option);

                System.out.println("Player 1 position: " + player1Pos);

                // If ladder, play again
                if (option != 1) {
                    isPlayer1Turn = false;
                }

            } else {
                diceCount2++;
                System.out.println("\nPlayer 2 rolled: " + dice);

                player2Pos = movePlayer(player2Pos, dice, option);

                System.out.println("Player 2 position: " + player2Pos);

                // If ladder, play again
                if (option != 1) {
                    isPlayer1Turn = true;
                }
            }
        }

        // UC 7 Winner
        if (player1Pos == 100) {
            System.out.println("\n🎉 Player 1 WON the game!");
            System.out.println("Dice rolled by Player 1: " + diceCount1);
        } else {
            System.out.println("\n🎉 Player 2 WON the game!");
            System.out.println("Dice rolled by Player 2: " + diceCount2);
        }
    }

    // Method to move player based on option
    public static int movePlayer(int position, int dice, int option) {

        switch (option) {

            case 0: // No Play
                System.out.println("No Play");
                break;

            case 1: // Ladder
                System.out.println("Ladder");
                if (position + dice <= 100) {
                    position += dice;
                }
                break;

            case 2: // Snake
                System.out.println("Snake");
                position -= dice;
                if (position < 0) {
                    position = 0;
                }
                break;
        }

        return position;
    }
}
