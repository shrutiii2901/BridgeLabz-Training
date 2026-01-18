import java.util.Scanner;

interface Discountable {
    double applyDiscount();
    void getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String name, double price, int qty) {
        this.itemName = name;
        this.price = price;
        this.quantity = qty;
    }

    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }

    public void getItemDetails() {
        System.out.println(itemName + " Qty: " + quantity + " Price: ₹" + price);
    }

    abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {

    VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    public void getDiscountDetails() {
        System.out.println("10% discount on Veg Item");
    }
}

class NonVegItem extends FoodItem implements Discountable {

    NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50;
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public void getDiscountDetails() {
        System.out.println("5% discount on Non-Veg Item");
    }
}

public class FoodDeliverySystem {

    static void processOrder(FoodItem item) {
        item.getItemDetails();
        System.out.println("Total Price: ₹" + item.calculateTotalPrice());

        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            d.getDiscountDetails();
            System.out.println("Discount: " + d.applyDiscount());
            System.out.println("Final Amount: " + (item.calculateTotalPrice() - d.applyDiscount()));
        }

    
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 for Veg Item, 2 for Non-Veg Item");
        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Food Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        FoodItem item;

        if (choice == 1) {
            item = new VegItem(name, price, qty);
        } else {
            item = new NonVegItem(name, price, qty);
        }

        processOrder(item);

        sc.close();
    }
}
