// ECommercePlatform.java
import java.util.*;

abstract class Product {
    private int productId;
    private String name;
    protected double price;

    public Product(int id, String name, double price) {
        this.productId = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return price * 0.10;
    }

    public double calculateTax() {
        return price * 0.18;
    }

    public String getTaxDetails() {
        return "18% GST";
    }
}

class Clothing extends Product {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return price * 0.20;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Laptop", 60000));
        products.add(new Clothing(2, "T-Shirt", 1000));

        for (Product p : products) {
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = p.price + tax - p.calculateDiscount();
            System.out.println("Final Price: " + finalPrice);
        }
    }
}
