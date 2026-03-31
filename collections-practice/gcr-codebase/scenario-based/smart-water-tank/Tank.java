import java.util.*;

public class Tank {
    private String tankID;
    private double capacity;
    private double currentWaterLevel;
    
    public Tank(String tankID, double capacity, double currentWaterLevel) throws InvalidWaterLevelException{
        if(currentWaterLevel>capacity){
            throw new  InvalidWaterLevelException("Water level cannot exceed tank capacity for Tank ID: " + tankID);
        }
        this.tankID=tankID;
        this.capacity=capacity;
        this.currentWaterLevel=currentWaterLevel;
    }

    public String getTankID(){
        return tankID;
    }
    public double getCapacity(){
        return capacity;
    }
    public double getCurrentLevel(){
        return currentWaterLevel;
    }

    public double getUsagePercentage(){
        return (currentWaterLevel/capacity) * 100;
    }

    public boolean isBelowThreshold(){
        return getUsagePercentage()<20;
    }

    @Override
    public String toString(){
        return "TankId : " +tankID+ "Capacity : " +capacity+ "Usage :" +getUsagePercentage();
    }

}
