// FoodDeliverySystem.java
abstract class FoodItem {
    protected String name;
    protected double price;
    protected int quantity;

    public FoodItem(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.quantity = qty;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return price * quantity - applyDiscount();
    }

    public double applyDiscount() {
        return 50;
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem item = new VegItem("Paneer", 200, 2);
        System.out.println("Total: " + item.calculateTotalPrice());
    }
}
