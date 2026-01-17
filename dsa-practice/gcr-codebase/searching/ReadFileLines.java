import java.io.*;

public class ReadFileLines {

    static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        readFile();
    }
}
