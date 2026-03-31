
import java.util.ArrayList;
import java.util.List;

public class Inventory implements AlertService {

    private List<Product> products = new ArrayList<>();
    private final int LOW_STOCK_LIMIT = 5;

    // Add Product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getProductName());
    }

    // Update Stock
    public void updateStock(String productId, int newQuantity) throws OutOfStockException {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                p.setQuantity(newQuantity);

                if (newQuantity == 0) {
                    throw new OutOfStockException(p.getProductName() + " is out of stock!");
                }

                if (newQuantity <= LOW_STOCK_LIMIT) {
                    sendLowStockAlert(p);
                }

                System.out.println("Stock updated for " + p.getProductName());
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // Display Inventory
    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Product p : products) {
            System.out.println(
                p.getProductName() + " | Quantity: " + p.getQuantity()
            );
        }
    }

    // Low-stock alert
    public void sendLowStockAlert(Product product) {
        System.out.println(
            "ALERT: Low stock for " + product.getProductName()
        );
    }
}