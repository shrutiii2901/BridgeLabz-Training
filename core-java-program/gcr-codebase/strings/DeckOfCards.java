import java.util.Scanner;
// method to deck of cards

class DeckOfCards {

    static String[] initializeDeck(String[] suits, String[] ranks) {
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int random = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
    }
    // method to distribute cards

    static String[][] distributeCards(String[] deck, int players, int cards) {
        if (players * cards > deck.length) {
            return null;
        }

        String[][] result = new String[players][cards];
        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cards; j++) {
                result[i][j] = deck[index++];
            }
        }
        return result;
    }

    static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (String card : players[i]) {
                System.out.println(card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);
        shuffleDeck(deck);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        System.out.print("Enter cards per player: ");
        int cards = sc.nextInt();

        String[][] result = distributeCards(deck, players, cards);

        if (result != null) {
            printPlayers(result);
        } else {
            System.out.println("Cannot distribute cards.");
        }
    }
}
