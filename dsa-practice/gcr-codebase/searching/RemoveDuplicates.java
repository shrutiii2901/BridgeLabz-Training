import java.util.*;

public class RemoveDuplicates {

    static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(char c : str.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();

        System.out.println("Without duplicates: " + removeDuplicates(str));
    }
}
