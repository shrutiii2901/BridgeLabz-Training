// CartItem class
class CartItems {

    // attributes
    String itemName;
    double price;
    int quantity;

    // method to display item details
    void displayItem() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }

    // method to add item quantity
    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // method to remove item quantity
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity = quantity - qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }

    // method to display total cost
    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Total cost: $" + totalCost);
    }

    // main method
    public static void main(String[] args) {

        CartItems cart = new CartItems();

        // initial item
        cart.itemName = "Laptop";
        cart.price = 999.99;
        cart.quantity = 1;

        cart.displayItem();
        cart.addItem(2);
        cart.removeItem(1);
        cart.displayTotalCost();
    }
}