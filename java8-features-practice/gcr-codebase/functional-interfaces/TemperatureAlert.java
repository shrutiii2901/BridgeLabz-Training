import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {

        Predicate<Double> isHighTemp = temp -> temp > 40;

        double temp = 45;

        if (isHighTemp.test(temp)) {
            System.out.println("High temperature alert!");
        }
    }
}
