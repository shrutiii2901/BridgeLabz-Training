
import java.util.*;

public class UserInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataCenterUtil util = new DataCenterUtil();

        System.out.println("Enter the number of data centers to be added");
        int n = sc.nextInt();
        sc.nextLine();   // important

        System.out.println("Enter data center details");

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] arr = input.split(":");

            String id = arr[0];
            String location = arr[1];
            String supervisor = arr[2];
            double power = Double.parseDouble(arr[3]);

            util.addDataCenter(new DataCenter(id, location, supervisor, power));
        }

        System.out.println("Enter the Data Center ID to get details");
        String id = sc.nextLine();

        DataCenter dc = util.getDataCenterById(id);
        if (dc == null) {
            System.out.println("Data Center not found for the ID " + id);
        } else {
            System.out.println(dc.getDataCenterId() + " | "
                    + dc.getLocation() + " | "
                    + dc.getsupervisorName() + " | "
                    + dc.getcoolingPowerUsage());
        }

        System.out.println("Data Centers with maximum cooling power usage");
        for (DataCenter d : util.getDataCentersWithMaximumCoolingPowerUsage()) {
            System.out.println(d.getDataCenterId() + " | "
                    + d.getLocation() + " | "
                    + d.getsupervisorName() + " | "
                    + d.getcoolingPowerUsage());
        }
    }
}
