
public class InventoryApp {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product("P101", "Laptop", 10);
        Product p2 = new Product("P102", "Mouse", 4);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.displayInventory();

        try {
            inventory.updateStock("P102", 3);
            inventory.updateStock("P101", 0);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        inventory.displayInventory();
    }
}