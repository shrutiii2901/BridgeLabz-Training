import java.util.*;

public class ConcatenateString {

    static String concatenateStrings(String[] arr) {
        StringBuffer sbf = new StringBuffer();
        for(String s : arr) {
            sbf.append(s);
        }
        return sbf.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println("Concatenated: " + concatenateStrings(arr));
    }
}
