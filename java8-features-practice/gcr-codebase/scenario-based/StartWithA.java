import java.util.List;
public class StartWithA {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Anna");

        System.out.println("Names starting with 'A':");
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
            }
        }
