import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Amit", "IT", 50000));
        list.add(new Employee(2, "Neha", "HR", 45000));

        
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> empList = (List<Employee>) ois.readObject();
            for (Employee e : empList) {
                System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
