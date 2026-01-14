interface Payment {
    void pay(double amount) throws PaymentFailedException;
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String msg) {
        super(msg);
    }
}

class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Payment successful via Card: ₹" + amount);
    }
}

class Order {
    int orderId;
    double amount;

    Order(int orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    void placeOrder(Payment payment) throws PaymentFailedException {
        payment.pay(amount);
        System.out.println("Order " + orderId + " placed successfully");
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        try {
            Order order = new Order(101, 2999);
            Payment payment = new CardPayment();
            order.placeOrder(payment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
