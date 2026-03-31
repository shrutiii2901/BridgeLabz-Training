import java.util.List;
import java.util.function.Predicate;

class Alert {
    String type;

    Alert(String type) {
        this.type = type;
    }

    public String toString() {
        return "Alert: " + type;
    }
}

public class NotificationFilter {
    public static void main(String[] args) {

        List<Alert> alerts = List.of(
                new Alert("Critical"),
                new Alert("General"),
                new Alert("Emergency"),
                new Alert("Reminder")
        );

        Predicate<Alert> criticalOnly = alert ->
                alert.type.equalsIgnoreCase("Critical") ||
                alert.type.equalsIgnoreCase("Emergency");

        alerts.stream()
              .filter(criticalOnly)
              .forEach(System.out::println);
    }
}
