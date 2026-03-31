import java.util.Scanner;

public class RemoveCharacterFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();

        System.out.print("Character to remove: ");
        char remove = sc.next().charAt(0);

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != remove) {
                result += str.charAt(i);
            }
        }

        System.out.println("Modified String: " + result);
    }
}
