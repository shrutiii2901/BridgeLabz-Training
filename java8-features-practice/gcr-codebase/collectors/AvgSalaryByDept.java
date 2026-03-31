import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class AvgSalaryByDept {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("A", "IT", 60000),
                new Employee("B", "IT", 80000),
                new Employee("C", "HR", 50000)
        );

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .filter(emp -> emp.getSalary() > 6000) 
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(avgSalaryByDept);
    }
}
