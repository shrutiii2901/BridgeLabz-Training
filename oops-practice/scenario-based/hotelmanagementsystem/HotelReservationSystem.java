import java.util.*;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reservation r = new Reservation();
        PricingStrategy pricing = new StandardRoom();

        try {
            System.out.print("Enter guest name: ");
            String guest = sc.nextLine();

            System.out.print("Enter number of days: ");
            int days = sc.nextInt();

            r.book();
            System.out.println("Room booked for " + guest);
            System.out.println("Total Bill: ₹" + pricing.calculatePrice(days));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}