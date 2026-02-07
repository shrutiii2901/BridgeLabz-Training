import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LeaveManagementSystem {

    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employeeMap.put(emp.getId(), emp);
    }

    public void requestLeave(int empId, int days) throws InsufficientLeaveBalanceException {
        Employee emp = employeeMap.get(empId);

        if (emp.getLeaveBalance() < days) {
            throw new InsufficientLeaveBalanceException("Not enough leave balance");
        }

        leaveRequests.add(new LeaveRequest(empId, days));
        System.out.println("Leave requested successfully");
    }

    public void approveLeave(int index) {
        LeaveRequest request = leaveRequests.get(index);
        Employee emp = employeeMap.get(request.employeeId);

        emp.deductLeave(request.days);
        request.status = "Approved";
        System.out.println("Leave approved");
    }
}
