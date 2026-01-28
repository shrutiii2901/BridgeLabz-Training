import java.util.*;

public class LexicalTwist {

    
    static boolean isValidWord(String word) {
        return !word.contains(" ");
    }

  
    static boolean isReverse(String first, String second) {
        String reversed = new StringBuilder(first).reverse().toString();
        return reversed.equalsIgnoreCase(second);
    }

   
    static String replaceVowels(String word) {
        return word.replaceAll("[aeiou]", "@");
    }

   
    static int countVowels(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if ("AEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    
    static int countConsonants(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z' && "AEIOU".indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }

   
    static String getFirstTwoUnique(String word, boolean vowels) {
        String result = "";
        for (char c : word.toCharArray()) {
            boolean isVowel = "AEIOU".indexOf(c) != -1;
            if (vowels == isVowel && result.indexOf(c) == -1) {
                result += c;
            }
            if (result.length() == 2) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        if (!isValidWord(first)) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        if (!isValidWord(second)) {
            System.out.println(second + " is an invalid word");
            return;
        }

        if (isReverse(first, second)) {
           
            String reversed = new StringBuilder(first).reverse().toString();
            reversed = reversed.toLowerCase();
            reversed = replaceVowels(reversed);
            System.out.println(reversed);
        } else {
           
            String combined = (first + second).toUpperCase();

            int vowelCount = countVowels(combined);
            int consonantCount = countConsonants(combined);

            if (vowelCount > consonantCount) {
                System.out.println(getFirstTwoUnique(combined, true));
            } else if (consonantCount > vowelCount) {
                System.out.println(getFirstTwoUnique(combined, false));
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }
}
