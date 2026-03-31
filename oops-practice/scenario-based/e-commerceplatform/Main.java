public class Main {
    public static void main(String[] args) {
        Product p = new Product("Laptop", 50000);
        Order o = new Order(p);
        Customer c = new Customer();

        try {
            c.pay(o.product.price);
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
