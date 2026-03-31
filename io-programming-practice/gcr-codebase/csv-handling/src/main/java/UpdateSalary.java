import java.io.*;

public class UpdateSalary {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new FileReader("data/employees.csv")
        );

        BufferedWriter bw = new BufferedWriter(
            new FileWriter("data/output/updated-employees.csv")
        );

        bw.write(br.readLine() + "\n");
        String line;

        while ((line = br.readLine()) != null) {
            String[] e = line.split(",");
            if (e[2].equals("IT")) {
                int salary = Integer.parseInt(e[3]);
                e[3] = String.valueOf((int)(salary * 1.10));
            }
            bw.write(String.join(",", e) + "\n");
        }

        br.close();
        bw.close();
    }
}
