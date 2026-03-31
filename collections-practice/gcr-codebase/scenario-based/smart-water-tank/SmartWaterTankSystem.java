
import java.util.*;

public class SmartWaterTankSystem {
    public static void main(String[] args) {
        List<Tank> tanks = new ArrayList<>();

        try {
            tanks.add(new Tank("T1",1000,150));
            tanks.add(new Tank("T2",2000,500));
            tanks.add(new Tank("T3",1500,100));
            tanks.add(new Tank("T4",1200,1100));

            tanks.add(new Tank("T3",1000,1200));

            
        } catch (InvalidWaterLevelException e) {
            System.out.println("Invalid current level" + e.getMessage());
        }

        tanks.sort(Comparator.comparingDouble(Tank::getCurrentLevel));

        System.out.println("Sorted Tanks by Lowest water level");

        for(Tank tank : tanks ){
            System.out.println(tanks);

            if(tank.isBelowThreshold()){
                System.out.println("Alert : Water level is below 20% for TankID : " + tank.getTankID());
            }
        }
    }
}
