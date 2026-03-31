import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    private String customer;
    private double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
}

public class OrderSummary {
    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Alice", 250.0),
                new Order("Bob", 300.0),
                new Order("Alice", 150.0)
        );

        Map<String, Double> revenueByCustomer =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        System.out.println(revenueByCustomer);
    }
}
