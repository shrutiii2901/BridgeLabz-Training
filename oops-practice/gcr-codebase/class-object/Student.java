import java.util.Scanner;

class Student {

    String name;
    String rollNumber;
    double mark1, mark2, mark3;

    char calculateGrade() {
        double average = (mark1 + mark2 + mark3) / 3;

        if (average >= 80)
            return 'A';
        else if (average >= 70)
            return 'B';
        else if (average >= 60)
            return 'C';
        else
            return 'D';
    }

    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + mark1 + ", " + mark2 + ", " + mark3);
        System.out.println("Grade: " + calculateGrade());
       
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student s = new Student();

        System.out.print("Enter Student Name: ");
        s.name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        s.rollNumber = sc.nextLine();

        System.out.print("Enter Mark 1: ");
        s.mark1 = sc.nextDouble();

        System.out.print("Enter Mark 2: ");
        s.mark2 = sc.nextDouble();

        System.out.print("Enter Mark 3: ");
        s.mark3 = sc.nextDouble();

        s.displayDetails();

        sc.close();
    }
}
