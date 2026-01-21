import java.util.*;

abstract class CourseType {
    String name;
    CourseType(String name) { this.name = name; }
    abstract void evaluate();
}

class ExamCourse extends CourseType {
    ExamCourse(String name) { super(name); }
    void evaluate() { System.out.println(name + " → Exam Evaluation"); }
}

class Course<T extends CourseType> {
    List<T> courses = new ArrayList<>();
    void addCourse(T c) { courses.add(c); }
    List<T> getCourses() { return courses; }
}

class CourseUtil {
    static void evaluateAll(List<? extends CourseType> list) {
        for (CourseType c : list)
            c.evaluate();
    }
}

public class UniversityMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course<ExamCourse> courseList = new Course<>();

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter course name: ");
            courseList.addCourse(new ExamCourse(sc.nextLine()));
        }

        CourseUtil.evaluateAll(courseList.getCourses());
    }
}
