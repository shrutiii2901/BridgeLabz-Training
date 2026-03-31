
import java.util.List;
public class StartsWithVowels {
 public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Anna");

        System.out.println("Names starting with a vowel:");
        names.stream()
                .filter(name -> name.matches("^[AEIOUaeiou].*"))
                .forEach(System.out::println);
            }
        }