public class Main {
    public static void main(String[] args) {

        LeaveManagementSystem system = new LeaveManagementSystem();

        system.addEmployee(new Employee(101, "Rahul", 10));

        try {
            system.requestLeave(101, 5);
            system.approveLeave(0);
        } catch (InsufficientLeaveBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
