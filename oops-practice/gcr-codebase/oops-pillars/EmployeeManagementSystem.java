
import java.util.*;

abstract class Employee {
    private int employeeId;
    private String name;
    protected double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name +
                ", Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public void assignDepartment(String dept) {
        this.department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hours) {
        super(id, name, hourlyRate);
        this.hoursWorked = hours;
    }

    public double calculateSalary() {
        return baseSalary * hoursWorked;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee e1 = new FullTimeEmployee(1, "Shruti", 50000);
        e1.assignDepartment("IT");

        PartTimeEmployee e2 = new PartTimeEmployee(2, "Aman", 500, 40);

        employees.add(e1);
        employees.add(e2);

        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}
