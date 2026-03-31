import java.util.Scanner;

class CharacterFrequencyUsingNestedLoops {

    
    static String[] characterFrequency(String text) {

        char[] chars = text.toCharArray();
        int[] frequency = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            frequency[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    frequency[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        String[] result = new String[chars.length];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + " : " + frequency[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[] output = characterFrequency(text);

        System.out.println("Character Frequency:");
        for (String s : output) {
            if (s != null)
                System.out.println(s);
        }
    }
}
