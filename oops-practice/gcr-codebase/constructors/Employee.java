class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public void setSalary(double s) {
        salary = s;
    }
}

class Manager extends Employee {
    void show() {
        System.out.println(employeeID + " " + department);
    }
}
