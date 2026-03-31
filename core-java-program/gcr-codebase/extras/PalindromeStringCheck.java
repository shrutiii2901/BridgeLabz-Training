import java.util.Scanner;

public class PalindromeStringCheck {
    public static void main(String[] args) {
        //take Input using Scanner Class
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        if (str.equals(rev))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}
