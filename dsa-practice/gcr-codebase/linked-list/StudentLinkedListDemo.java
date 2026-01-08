import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    // Add at beginning
    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
        System.out.println("Student added at beginning.");
    }

    // Add at end
    public void addAtEnd(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);

        if (head == null) {
            head = newStudent;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
        System.out.println("Student added at end.");
    }

    // Add at specific position
    public void addAtPosition(int pos, int rollNo, String name, int age, char grade) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        Student newStudent = new Student(rollNo, name, age, grade);
        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
        System.out.println("Student added at position " + pos);
    }

    // Delete by roll number
    public void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted.");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted.");
        }
    }

    // Search by roll number
    public void searchByRollNo(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found:");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade
    public void updateGrade(int rollNo, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all students
    public void display() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("------------------------");
            System.out.println("Roll No: " + temp.rollNo);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentLinkedListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n---- Student Record Management ----");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll No");
            System.out.println("5. Search by Roll No");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    int r1 = sc.nextInt();
                    System.out.print("Name: ");
                    String n1 = sc.next();
                    System.out.print("Age: ");
                    int a1 = sc.nextInt();
                    System.out.print("Grade: ");
                    char g1 = sc.next().charAt(0);
                    list.addAtBeginning(r1, n1, a1, g1);
                    break;

                case 2:
                    System.out.print("Roll No: ");
                    int r2 = sc.nextInt();
                    System.out.print("Name: ");
                    String n2 = sc.next();
                    System.out.print("Age: ");
                    int a2 = sc.nextInt();
                    System.out.print("Grade: ");
                    char g2 = sc.next().charAt(0);
                    list.addAtEnd(r2, n2, a2, g2);
                    break;

                case 3:
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Roll No: ");
                    int r3 = sc.nextInt();
                    System.out.print("Name: ");
                    String n3 = sc.next();
                    System.out.print("Age: ");
                    int a3 = sc.nextInt();
                    System.out.print("Grade: ");
                    char g3 = sc.next().charAt(0);
                    list.addAtPosition(pos, r3, n3, a3, g3);
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    list.deleteByRollNo(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    list.searchByRollNo(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    char g = sc.next().charAt(0);
                    list.updateGrade(r, g);
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);

        sc.close();
    }
}
