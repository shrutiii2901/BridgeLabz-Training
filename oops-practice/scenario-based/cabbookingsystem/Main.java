public class Main {
    public static void main(String[] args) {
        Driver d = new Driver("Amit");
        Ride r = new Ride(d);

        try {
            r.bookRide();
            System.out.println("Fare: " + r.calculateFare(5));
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
