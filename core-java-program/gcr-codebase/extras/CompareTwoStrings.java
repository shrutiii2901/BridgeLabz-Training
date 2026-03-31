public class CompareTwoStrings {
    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "banana";

        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }

        if (i == s1.length() && i == s2.length())
            System.out.println("Both strings are equal");
        else if (i == s1.length() || (i < s1.length() && s1.charAt(i) < s2.charAt(i)))
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\"");
        else
            System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\"");
    }
}
