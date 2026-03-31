public class CashOrder extends Order {
    private final int orderId;
    private final double amount;

    public CashOrder(int orderId, double amount) {
        super(orderId, amount);
        this.orderId = orderId;
        this.amount = amount;
    }

    @Override
    public double getDiscountedPrice() {
        return amount - (amount * 0.02); 
    }
    
}
