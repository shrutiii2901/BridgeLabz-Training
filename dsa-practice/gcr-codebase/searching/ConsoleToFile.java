import java.io.*;

public class ConsoleToFile {

    static void writeInputToFile() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        String line;
        while(!(line = br.readLine()).equalsIgnoreCase("exit")) {
            bw.write(line);
            bw.newLine();
        }

        bw.close();
        System.out.println("Saved to file.");
    }

    public static void main(String[] args) throws Exception {
        writeInputToFile();
    }
}
