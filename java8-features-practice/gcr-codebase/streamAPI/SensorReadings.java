import java.util.List;

public class SensorReadings {
    public static void main(String[] args) {

        List<Integer> readings = List.of(30, 55, 80, 45);
        int threshold = 50;

        readings.stream()
                .filter(r -> r > threshold)
                .forEach(r -> System.out.println("High Reading: " + r));
    }
}
