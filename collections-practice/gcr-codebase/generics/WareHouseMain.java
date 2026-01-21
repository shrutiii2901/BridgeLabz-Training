import java.util.*;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) {
        this.name = name;
    }
    abstract void display();
}

class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
    void display() { 
        System.out.println("Electronics: " + name); 
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
    void display() {
         System.out.println("Grocery: " + name); 
        }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
    void display() {
         System.out.println("Furniture: " + name); 
        }
}

class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();
    void addItem(T item) {
         items.add(item); 
        }
    List<T> getItems() {
         return items; 
        }
}

class WarehouseUtil {
    static void displayAll(List<? extends WarehouseItem> list) {
        for (WarehouseItem i : list)
            i.display();
    }
}

public class WareHouseMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage<Electronics> storage = new Storage<>();

        System.out.print("Enter number of electronics items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item name: ");
            storage.addItem(new Electronics(sc.nextLine()));
        }

        WarehouseUtil.displayAll(storage.getItems());
    }
}
