import java.io.*;
import java.util.*;

class Student {
    int id, age, marks;
    String name;

    Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}

public class CSVToStudentObject {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();

        BufferedReader br = new BufferedReader(
            new FileReader("data/students.csv")
        );

        br.readLine();
        String line;

        while ((line = br.readLine()) != null) {
            String[] s = line.split(",");
            students.add(new Student(
                Integer.parseInt(s[0]),
                s[1],
                Integer.parseInt(s[2]),
                Integer.parseInt(s[3])
            ));
        }
        br.close();

        students.forEach(st ->
            System.out.println(st.name + " : " + st.marks)
        );
    }
}
