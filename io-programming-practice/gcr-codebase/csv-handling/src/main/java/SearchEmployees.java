import java.io.*;

public class SearchEmployees {
    public static void main(String[] args) throws Exception {
        String searchName = "Neha";

        BufferedReader br = new BufferedReader(
            new FileReader("data/employees.csv")
        );

        br.readLine();
        String line;

        while ((line = br.readLine()) != null) {
            String[] e = line.split(",");
            if (e[1].equalsIgnoreCase(searchName)) {
                System.out.println(
                    "Department: " + e[2] +
                    ", Salary: " + e[3]
                );
            }
        }
        br.close();
    }
}
