import java.io.*;

public class InputStreamReaderFileRead {

    static void readFileWithEncoding(String filename) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(filename), "UTF-8"));

        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        readFileWithEncoding("input.txt");
    }
}
