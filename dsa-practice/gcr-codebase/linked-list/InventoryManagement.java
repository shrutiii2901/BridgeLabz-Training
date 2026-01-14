class ItemNode {
    int id, qty;
    String name;
    double price;
    ItemNode next;

    ItemNode(int i, String n, int q, double p) {
        id = i; name = n; qty = q; price = p;
    }
}

class Inventory {
    ItemNode head;

    void addItem(int i, String n, int q, double p) {
        ItemNode node = new ItemNode(i, n, q, p);
        node.next = head;
        head = node;
    }

    double totalValue() {
        double sum = 0;
        ItemNode temp = head;
        while (temp != null) {
            sum += temp.qty * temp.price;
            temp = temp.next;
        }
        return sum;
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addItem(101, "Pen", 10, 5);
        inv.addItem(102, "Book", 5, 100);

        System.out.println("Total Inventory Value: " + inv.totalValue());
    }
}
