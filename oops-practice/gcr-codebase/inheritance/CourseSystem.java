import java.util.Scanner;

class Course {
    String courseName;
    int duration;

    Course(String name, int duration) {
        this.courseName = name;
        this.duration = duration;
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String name, int duration, String platform, boolean isRecorded) {
        super(name, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee, discount;

    PaidOnlineCourse(String name, int duration, String platform, boolean recorded, double fee, double discount) {
        super(name, duration, platform, recorded);
        this.fee = fee;
        this.discount = discount;
    }

    void displayCourse() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
        System.out.println("Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class CourseSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Duration: ");
        int duration = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Platform: ");
        String platform = sc.nextLine();

        System.out.print("Is Recorded (true/false): ");
        boolean recorded = sc.nextBoolean();

        System.out.print("Enter Fee: ");
        double fee = sc.nextDouble();

        System.out.print("Enter Discount: ");
        double discount = sc.nextDouble();

        PaidOnlineCourse p = new PaidOnlineCourse(name, duration, platform, recorded, fee, discount);
        p.displayCourse();
    }
}
