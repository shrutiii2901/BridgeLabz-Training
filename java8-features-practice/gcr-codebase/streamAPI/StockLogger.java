import java.util.*;

public class StockLogger {
    public static void main(String[] args) {

        List<Double> prices = List.of(120.5, 121.0, 119.8);

        prices.forEach(price ->
                System.out.println("Stock Price: " + price));
    }
}
