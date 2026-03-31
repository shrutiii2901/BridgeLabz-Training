public class Customer implements Payment {
   
    @Override
    public void pay(double amount) throws PaymentFailedException {
       
        if (amount <= 0) {
            throw new PaymentFailedException("Payment amount must be greater than zero.");
        }
        System.out.println("Payment of $" + amount + " made successfully ");
    }
}