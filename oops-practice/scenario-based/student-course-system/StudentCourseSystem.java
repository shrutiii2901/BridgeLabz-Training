class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String msg) {
        super(msg);
    }
}

abstract class Person {
    String name;
}

class Student extends Person {
    int enrolledCourses = 0;
    static final int MAX_COURSES = 3;

    Student(String name) {
        this.name = name;
    }

    void enrollCourse() throws CourseLimitExceededException {
        if (enrolledCourses >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded!");
        }
        enrolledCourses++;
        System.out.println(name + " enrolled in course. Total: " + enrolledCourses);
    }
}

public class StudentCourseSystem {
    public static void main(String[] args) {
        try {
            Student s = new Student("Shruti");
            s.enrollCourse();
            s.enrollCourse();
            s.enrollCourse();
            s.enrollCourse(); // Exception
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }
}
