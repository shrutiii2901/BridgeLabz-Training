import java.util.Scanner;

class PalindromeChecker {

    String text;

    boolean isPalindrome() {
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = cleanText.length() - 1;

        while (start < end) {
            if (cleanText.charAt(start) != cleanText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PalindromeChecker p = new PalindromeChecker();

        System.out.print("Enter a string: ");
        p.text = sc.nextLine();

        p.displayResult();

        sc.close();
    }
}
