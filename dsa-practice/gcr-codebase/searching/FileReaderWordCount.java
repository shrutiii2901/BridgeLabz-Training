import java.io.*;
import java.util.*;

public class FileReaderWordCount {

    static int countWordInFile(String filename, String target) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int count = 0;
        String line;

        while((line = br.readLine()) != null) {
            for(String word : line.split("\\s+")) {
                if(word.equalsIgnoreCase(target)) {
                    count++;
                }
            }
        }
        br.close();
        return count;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = sc.nextLine();

        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        System.out.println("Occurrences: " + countWordInFile(file, word));
    }
}
