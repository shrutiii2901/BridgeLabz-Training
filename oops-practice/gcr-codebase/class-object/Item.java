import java.util.Scanner;

class Item {

    String itemCode;
    String itemName;
    double price;

    void displayItem() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Item Price: " + price);
        
    }

    void calculateTotalCost(int quantity) {
        double totalCost = price * quantity;
        System.out.println("Total cost for " + quantity + " units: " + totalCost);
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Item item = new Item();

        System.out.print("Enter Item Code: ");
        item.itemCode = sc.nextLine();

        System.out.print("Enter Item Name: ");
        item.itemName = sc.nextLine();

        System.out.print("Enter Item Price: ");
        item.price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.println("\nItem Details:");
        item.displayItem();

        item.calculateTotalCost(qty);

        sc.close();
    }
}
