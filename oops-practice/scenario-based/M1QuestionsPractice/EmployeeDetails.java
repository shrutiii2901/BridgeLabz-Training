import java.util.Scanner;
class Employee{
    private String name;
    private String title;
    private double salary;

    public Employee(String name, String title, double salary){
        this.name=name;
        this.title=title;
        this.salary=salary;
    }

    public double calculateSalaryYearly(){
        return salary*12;
    }

    public double updateSalary(double percentage){
        salary = salary + (salary/percentage*10);
        return salary;
    }

    public void display(){
        System.out.println("Name of the Employee : "+name);
        System.out.println("Job title : " + title);
        System.out.println("Montly Salary : " + salary);
    }

}
public class EmployeeDetails {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee("Shruti", "SDE",20000);

        emp.display();

        System.out.println("The Yearly Salary of employee : " + emp.calculateSalaryYearly());

        System.out.println("The updated salary is : " + emp.updateSalary(10));
    }
}

