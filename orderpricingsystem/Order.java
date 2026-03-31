abstract class Order {
    private final int orderId;
    private final double amount;
    
    public Order(int orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
}

    public int getOrderId() {
        return orderId;
    }
    public double getAmount() {
        return amount;
    }
    public abstract double getDiscountedPrice();
    
}

