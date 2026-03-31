
public class Ride implements FareCalculator {
 
    Driver driver;

    public Ride(Driver driver) {
        this.driver = driver;
    }

    public void bookRide() throws NoDriverAvailableException {
        if (driver == null) {
            throw new NoDriverAvailableException("No driver available at the moment.");
        }
        System.out.println("Ride booked with driver: " + driver.name);
    }
    public double calculateFare(int km) {
        return km * 10.0;
    }
}
