// PalindromeChecker class
class PalindromeChecker {

    // attribute
    String text;

    // method to check palindrome
    boolean isPalindrome() {

        // remove spaces and convert to lowercase
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

    // method to display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }

    // main method
    public static void main(String[] args) {

        // first string
        PalindromeChecker p1 = new PalindromeChecker();
        p1.text = "A man a plan a canal Panama";
        p1.displayResult();

        // second string
        PalindromeChecker p2 = new PalindromeChecker();
        p2.text = "Hello";
        p2.displayResult();
    }
}