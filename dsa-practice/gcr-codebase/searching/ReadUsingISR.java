import java.io.*;

public class ReadUsingISR {

    static void readEncodedFile() throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));

        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        readEncodedFile();
    }
}
