import java.util.Scanner;

public class FlipKey {

    public static String CleanseAndInvert(String input) {

      
        if (input == null || input.length() < 6) {
            return "";
        }

      
        for (char ch : input.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return "";
            }
        }

      
        input = input.toLowerCase();

        
        StringBuilder filtered = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch % 2 != 0) { // odd ASCII
                filtered.append(ch);
            }
        }

        
        filtered.reverse();

        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0) {
                filtered.setCharAt(i,
                        Character.toUpperCase(filtered.charAt(i)));
            }
        }

        return filtered.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");
        String input = sc.nextLine();

        String result = CleanseAndInvert(input);

        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }

        sc.close();
    }
}
