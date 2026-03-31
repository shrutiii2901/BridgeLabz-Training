
import java.util.Scanner;

public class UserInterface {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        System.out.println("Enter flight details ");
       try {
            String input = sc.nextLine();

            String [] data = input.split(":");
            String flightNumber = data[0];
            String flightName = data[1];
            int passengerCount = Integer.parseInt(data[2]);
            double fuelLevel = Double.parseDouble(data[3]);

            util.validateFlightName(flightName);
            util.validateFlightNumber(flightNumber);
            util.validatePassengerCount(passengerCount, flightName);
            double fuel = util.calculateFuelToFillTank(flightName, fuelLevel);
            System.out.println("Fuel required to fill the tank: " +fuel+" litres ");


       } catch (InvalidFlightException e) {
        System.out.println(e.getMessage());
       }

        
    }
}
