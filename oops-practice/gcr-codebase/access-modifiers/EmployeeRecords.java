import java.util.Scanner;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public void setSalary(double s) {
        salary = s;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    void show() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Manager m = new Manager();

        System.out.print("Enter Employee ID: ");
        m.employeeID = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Department: ");
        m.department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();
        m.setSalary(sal);

        System.out.println("\nManager Details:");
        m.show();

        sc.close();
    }
}
