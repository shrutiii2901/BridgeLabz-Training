import java.util.*;

abstract class JobRole {
    abstract void screen();
}

class SoftwareEngineer extends JobRole {
    void screen() {
        System.out.println("Screening Software Engineer Resume");
    }
}

class DataScientist extends JobRole {
    void screen() {
        System.out.println("Screening Data Scientist Resume");
    }
}

class Resume<T extends JobRole> {
    T role;
    Resume(T role) { this.role = role; }
    void process() { role.screen(); }
}

public class ResumeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter role (1-SE, 2-DS): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            Resume<SoftwareEngineer> r = new Resume<>(new SoftwareEngineer());
            r.process();
        } else if (choice == 2) {
            Resume<DataScientist> r = new Resume<>(new DataScientist());
            r.process();
        } else {
            System.out.println("Invalid role");
        }
    }
}
