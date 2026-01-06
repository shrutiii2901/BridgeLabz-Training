import java.util.*;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    String name;
    int[] marks;
    String[] subjects;

    public Student(String name, String[] subjects, int[] marks)
            throws InvalidMarkException {

        this.name = name;
        this.subjects = subjects;
        this.marks = marks;

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Marks must be between 0 and 100");
            }
        }
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / (double) marks.length;
    }

    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 80) return "A";
        if (avg >= 60) return "B";
        if (avg >= 40) return "C";
        return "Fail";
    }

    public void displayReport() {
        System.out.println("\nReport Card: " + name);
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + getGrade());
    }
}

public class StudentReportGenerator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try {
            students.add(new Student(
                    "John",
                    new String[]{"Math", "Science", "English"},
                    new int[]{85, 78, 90}
            ));

            for (Student s : students) {
                s.displayReport();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
