import java.time.LocalDate;
import java.util.List;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return name + " | Expiry: " + expiryDate;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {

        List<Member> members = List.of(
                new Member("Alice", LocalDate.now().plusDays(10)),
                new Member("Bob", LocalDate.now().plusDays(40)),
                new Member("Charlie", LocalDate.now().plusDays(25))
        );

        members.stream()
               .filter(m -> m.expiryDate.isBefore(LocalDate.now().plusDays(30)))
               .forEach(System.out::println);
    }
}
