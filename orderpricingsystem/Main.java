
public class Main {
    public static void main(String[] args) {
        Order cc = new CreditCardOrder(101, 200.0);
        Order co = new CashOrder(102, 100);
        System.out.println("Credit  Card discounted price : " + cc.getDiscountedPrice());
        System.out.println("Cash Order discounted Price : " + co.getDiscountedPrice());
        
    }
}