import java.util.*;

public class TrafficManagerApp {
    public static void main(String[] args) {

        TrafficManager manager = new TrafficManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TRAFFIC MANAGER =====");
            System.out.println("1. Add Vehicle to Queue");
            System.out.println("2. Enter Roundabout");
            System.out.println("3. Exit Roundabout");
            System.out.println("4. Display State");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> manager.addVehicleToQueue();
                    case 2 -> manager.enterRoundabout();
                    case 3 -> manager.exitRoundabout();
                    case 4 -> manager.displayState();
                    case 5 -> {
                        System.out.println("Exiting Traffic Manager...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}