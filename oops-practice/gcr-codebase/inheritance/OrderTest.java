class Order {
    int orderId;
    String orderDate;

    Order(int id, String date) {
        orderId = id;
        orderDate = date;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int id, String date, String track) {
        super(id, date);
        trackingNumber = track;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int id, String date, String track, String delivery) {
        super(id, date, track);
        deliveryDate = delivery;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OrderTest {
    public static void main(String[] args) {
        Order o = new DeliveredOrder(101, "01-Jan", "TR123", "05-Jan");
        System.out.println(o.getOrderStatus());
    }
}
