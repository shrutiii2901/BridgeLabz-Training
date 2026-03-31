
import java.util.List;

public class GetFirstLetter {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Anna");
        System.out.println("First letters of names:");
        names.stream()
                .map(name -> name.substring(0, 1))
                .forEach(System.out::println);
    }
}
