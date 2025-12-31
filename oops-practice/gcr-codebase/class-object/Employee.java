// Employee class
class Employee {

    // attributes
    String name;
    int id;
    double salary;

    // method to display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    // main method
    public static void main(String[] args) {

        // creating object of Employee
        Employee emp = new Employee();

        // assigning values
        emp.name = "Rohan";
        emp.id = 1;
        emp.salary = 500000;

        // calling display method
        emp.displayDetails();
    }
}