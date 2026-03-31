interface PaymentProcessor {
    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refunded: " + amount);
    }
}

class GooglePay implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid " + amount);
    }
}

public class PaymentGatewayDemo {
    public static void main(String[] args) {
        PaymentProcessor p = new GooglePay();
        p.pay(500);
        p.refund(200);
    }
}
