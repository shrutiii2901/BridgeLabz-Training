import java.util.ArrayList;
import java.util.List;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
  
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
   
    public abstract double calculateDiscount();
    
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public void displayProduct() {
        System.out.println("Product ID : " + productId);
        System.out.println("Name       : " + name);
        System.out.println("Base Price : " + price);
    }
}


 

class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; 
    }

    @Override
    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}


 
 
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; 
    }

    @Override
    public String getTaxDetails() {
        return "12% GST on Clothing";
    }
}


class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; 
    }
}


public class ECommercePlatform {

    
    public static void calculateFinalPrice(List<Product> products) {
        for (Product product : products) {
            double tax = 0;
            
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            } else {
                System.out.println("No tax applicable");
            }
            double discount = product.calculateDiscount();
            double finalPrice = product.getPrice() + tax - discount;
            product.displayProduct();
            System.out.println("Discount   : " + discount);
            System.out.println("Tax        : " + tax);
            System.out.println("Final Price: " + finalPrice);
        }
    }

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();

        productList.add(new Electronics(101, "Laptop", 60000));
        productList.add(new Clothing(102, "T-Shirt", 2000));
        productList.add(new Groceries(103, "Rice Bag", 1200));

        calculateFinalPrice(productList);
    }
}