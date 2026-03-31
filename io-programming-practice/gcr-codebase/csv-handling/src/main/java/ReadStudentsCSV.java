import java.io.*;

public class ReadStudentsCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new FileReader("data/students.csv")
        );

        String line = br.readLine(); 
        while ((line = br.readLine()) != null) {
            String[] s = line.split(",");
            System.out.println(
                "ID: " + s[0] +
                ", Name: " + s[1] +
                ", Age: " + s[2] +
                ", Marks: " + s[3]
            );
        }
        br.close();
    }
}
