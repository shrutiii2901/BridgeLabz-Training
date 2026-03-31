import java.util.Scanner;

class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    public void setCGPA(double c) {
        cgpa = c;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class PostgraduateStudent extends Student {
    void display() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}

public class StudentRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PostgraduateStudent s = new PostgraduateStudent();

        System.out.print("Enter Roll Number: ");
        s.rollNumber = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Name: ");
        s.name = sc.nextLine();

        System.out.print("Enter CGPA: ");
        double cg = sc.nextDouble();
        s.setCGPA(cg);

        System.out.println("\nStudent Details:");
        s.display();

        sc.close();
    }
}
