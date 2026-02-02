import java.io.*;
import java.util.*;

public class MergeStudents {
    public static void main(String[] args) throws Exception {

        Map<String, String> map = new HashMap<>();

        BufferedReader br1 = new BufferedReader(
            new FileReader("data/student1.csv")
        );
        br1.readLine();
        String line;

        while ((line = br1.readLine()) != null) {
            String[] s = line.split(",");
            map.put(s[0], line);
        }
        br1.close();

        BufferedReader br2 = new BufferedReader(
            new FileReader("data/student2.csv")
        );
        BufferedWriter bw = new BufferedWriter(
            new FileWriter("data/output/merged-students.csv")
        );

        bw.write("id,name,age,marks,grade\n");
        br2.readLine();

        while ((line = br2.readLine()) != null) {
            String[] s = line.split(",");
            bw.write(map.get(s[0]) + "," + s[1] + "," + s[2] + "\n");
        }

        br2.close();
        bw.close();
    }
}
