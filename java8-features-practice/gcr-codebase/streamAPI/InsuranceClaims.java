import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}


public class InsuranceClaims {
    public static void main(String[] args) {

        List<Claim> claims = List.of(
                new Claim("Health", 50000),
                new Claim("Health", 30000),
                new Claim("Vehicle", 20000),
                new Claim("Vehicle", 40000)
        );

        Map<String, Double> avgClaim = claims.stream()
                .collect(Collectors.groupingBy(
                        c -> c.type,
                        Collectors.averagingDouble(c -> c.amount)
                ));

        avgClaim.forEach((k, v) ->
                System.out.println(k + " Average Claim: " + v));
    }
}
