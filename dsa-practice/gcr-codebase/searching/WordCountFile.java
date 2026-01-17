import java.io.*;
import java.util.*;

public class WordCountFile {

    static int countWord(String target) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int count = 0;
        String line;

        while((line = br.readLine()) != null) {
            for(String word : line.split(" ")) {
                if(word.equalsIgnoreCase(target)) count++;
            }
        }
        br.close();
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        System.out.println("Occurrences: " + countWord(word));
    }
}
