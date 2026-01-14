class StudentNode {
    int roll, age;
    String name, grade;
    StudentNode next;

    StudentNode(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    StudentNode head;

    void addStudent(int roll, String name, int age, String grade) {
        StudentNode node = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = node;
        } else {
            StudentNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    void deleteStudent(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.roll != roll)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    void updateGrade(int roll, String grade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = grade;
                return;
            }
            temp = temp.next;
        }
    }

    void display() {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList list = new StudentList();

        list.addStudent(1, "Shruti", 20, "A");
        list.addStudent(2, "Aman", 21, "B");
        list.addStudent(3, "Neha", 19, "A");

        list.updateGrade(2, "A+");
        list.deleteStudent(1);

        System.out.println("Student Records:");
        list.display();
    }
}
