import java.util.List;

public class CustomerNames {
    public static void main(String[] args) {

        List<String> names = List.of("shruti", "amit", "neha");

        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}
