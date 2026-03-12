
public class FlightUtil {

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (flightNumber.matches("FL-[1-9][0-9]{3}")) {
            return true;
        } else {
            throw new InvalidFlightException("The flight number" + flightNumber + "is invalid.");
        }
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (flightName.matches("SpiceJet")
                || flightName.matches("Vistara")
                || flightName.matches("Indigo")
                || flightName.matches("Air Arabia")) {
            return true;
        } else {
            throw new InvalidFlightException("The flight name " + flightName + "is invalid");
        }
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        int maxCapacity = 0;
        switch (flightName) {
            case ("SpiceJet"):
                maxCapacity = 396;
                break;
            case ("Vistara"):
                maxCapacity = 615;
                break;
            case ("Indigo"):
                maxCapacity = 230;
                break;
            case ("Air Arabia"):
                maxCapacity = 130;
                break;

        }

        if(passengerCount<=0 || passengerCount>maxCapacity){
            throw new InvalidFlightException(
                "The passenger count " +passengerCount+ "is invalid for " +flightName );
           
        } 
         return true;

    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException{
        double capacity =0;
        if(flightName.equals("SpiceJet")){
            capacity=200000;
        }else if(flightName.equals("Vistara")){
            capacity=300000;
        }else if(flightName.equals("Indigo")){
            capacity=250000;
        }else if(flightName.equals("Air Arabia")){
            capacity=150000;
        }else if(currentFuelLevel<0 || currentFuelLevel>capacity){
            throw new InvalidFlightException("Invalid fuel level for " +flightName);
        }
        return capacity-currentFuelLevel;
    }
}
