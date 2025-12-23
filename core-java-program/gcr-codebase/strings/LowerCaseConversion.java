import java.util.Scanner;
// method for lower case

class LowerCaseConversion {

    static String toLowerUsingCharAt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result += ch;
        }
        return result;
    }
    // function to compare two strings

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
// main method
    public static void main(String[] args) {
        // take input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String customLower = toLowerUsingCharAt(text);
        String builtInLower = text.toLowerCase();

        System.out.println("Match result: " +
                compareStrings(customLower, builtInLower));
    }
}