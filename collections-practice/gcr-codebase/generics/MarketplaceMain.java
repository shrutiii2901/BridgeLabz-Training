import java.util.*;

abstract class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(name + " : ₹" + price);
    }
}

class Book extends Product {
    Book(String name, double price) {
         super(name, price); 
        }
}

class DiscountUtil {
    static <T extends Product> void applyDiscount(T p, double percent) {
        p.price -= p.price * percent / 100;
    }
}

public class MarketplaceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Book book = new Book(name, price);

        System.out.print("Enter discount percentage: ");
        double discount = sc.nextDouble();

        DiscountUtil.applyDiscount(book, discount);
        book.display();
    }
}
