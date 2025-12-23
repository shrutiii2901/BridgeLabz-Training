import java.util.Scanner;

class Palindrome {
    

    static boolean isPalindromeLoop(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    // method to reverse string

    static char[] reverseString(String text) {
        char[] rev = new char[text.length()];
        int index = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            rev[index++] = text.charAt(i);
        }
        return rev;
    }

    static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i])
                return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Loop Logic: " + isPalindromeLoop(text));
        System.out.println("Recursive Logic: " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Array Logic: " + isPalindromeArray(text));
    }
}
