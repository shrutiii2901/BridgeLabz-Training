
import java.awt.geom.Area;
import java.util.*;

public class DIsasterReliefSystem {
    public static void main(String[] args) {
        Map<String,ReliefCenter> centers = new HashMap<>();

        ReliefCenter center1 = new ReliefCenter("Center-1");
        center1.addResources("Food", 100);
        center1.addResources("Water", 200);
        center1.addResources("Medicines", 50);

        centers.put(center1.getCenterName(),center1);

        Queue<AreaRequest> requests = new LinkedList<>();

        Map<String,Integer> r1 = new HashMap<>();
        r1.put("Food", 80);
        r1.put("Water",30);

        Map<String, Integer> r2 = new HashMap<>();
        r2.put("Food",90);
        r2.put("Medicines",10);

        requests.add(new AreaRequest("Area-1", r1));
        requests.add(new AreaRequest("Area-2", r2));

        System.out.println("Allocation - ");

        while(!requests.isEmpty()){
            AreaRequest req = requests.poll();

            try {
                center1.allocate(req);
                System.out.println("Allocated To " + req.getAreaName());
                
            } catch (InsufficientResourceException e) {
                System.out.println("Failed For " + req.getAreaName() + " : " + e.getMessage());
            }
        }
        System.out.println("Remaining stocks -");
        center1.getStock().forEach((k,v)->System.out.println(k+ " : "+v));
        
    }
}
