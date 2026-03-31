import java.util.Scanner;

class VowelConsonantCount {

    
    static String checkCharacterType(char ch) {

        
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    
    static int[] countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            String result = checkCharacterType(text.charAt(i));

            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] count = countVowelsAndConsonants(text);

        System.out.println("Vowel Count: " + count[0]);
        System.out.println("Consonant Count: " + count[1]);
    }
}