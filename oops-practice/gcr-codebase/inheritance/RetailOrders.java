import java.util.Scanner;

class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int id, String date, String track, String deliveryDate) {
        super(id, date, track);
        this.deliveryDate = deliveryDate;
    }

    void getOrderStatus() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Delivered On: " + deliveryDate);
    }
}

public class RetailOrders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Order ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Order Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Tracking Number: ");
        String tracking = sc.nextLine();

        System.out.print("Enter Delivery Date: ");
        String delivery = sc.nextLine();

        DeliveredOrder d = new DeliveredOrder(id, date, tracking, delivery);
        d.getOrderStatus();
    }
}
