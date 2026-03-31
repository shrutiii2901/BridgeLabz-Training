import java.io.*;

public class CountStudents {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new FileReader("data/students.csv")
        );

        int count = -1; 
        while (br.readLine() != null) count++;

        br.close();
        System.out.println("Total students: " + count);
    }
}
