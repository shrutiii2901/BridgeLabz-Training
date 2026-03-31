public class Vehicle {
    
    private String vehicleNumber;
    private double  unitsConsumed;

    public Vehicle(String vehiNumber, double unitsConsumed){
        this.vehicleNumber=vehiNumber;
        this.unitsConsumed=unitsConsumed;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public double getUnitConsumed(){
        return unitsConsumed;
    }

    
}
