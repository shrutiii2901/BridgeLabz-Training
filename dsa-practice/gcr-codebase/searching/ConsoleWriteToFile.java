import java.io.*;

public class ConsoleWriteToFile {

    static void writeConsoleToFile(String filename) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        System.out.println("Enter text (type 'exit' to stop):");

        String line;
        while(!(line = br.readLine()).equalsIgnoreCase("exit")) {
            bw.write(line);
            bw.newLine();
        }

        bw.close();
        System.out.println("Saved to " + filename);
    }

    public static void main(String[] args) throws Exception {
        writeConsoleToFile("output.txt");
    }
}
