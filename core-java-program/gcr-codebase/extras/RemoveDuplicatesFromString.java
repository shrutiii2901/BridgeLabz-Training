import java.util.Scanner;

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(String.valueOf(str.charAt(i)))) {
                result += str.charAt(i);
            }
        }

        System.out.println("After Removing Duplicates: " + result);
    }
}
