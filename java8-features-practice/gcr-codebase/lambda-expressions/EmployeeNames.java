import java.util.List;
import java.util.stream.Collectors;

public class EmployeeNames {
    public static void main(String[] args) {

        List<String> names = List.of("Shruti", "Amit", "Neha");

        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());

        upperNames.forEach(System.out::println);
    }
}
