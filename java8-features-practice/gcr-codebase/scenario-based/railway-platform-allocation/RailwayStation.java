import java.util.*;

public class RailwayStation {

    private Map<Integer, Platform> platforms = new HashMap<>();
    private PriorityQueue<Train> trainQueue = new PriorityQueue<>();

    public RailwayStation(int totalPlatforms) {

        for(int i = 1; i <= totalPlatforms; i++) {
            platforms.put(i, new Platform(i));
        }
    }

    public void addTrain(Train train) {
        trainQueue.add(train);
    }

    public void allocatePlatforms() throws PlatformUnavailableException {

        while(!trainQueue.isEmpty()) {

            Train train = trainQueue.poll();
            Platform allocated = null;

            for(Platform platform : platforms.values()) {

                if(platform.isAvailable()) {
                    platform.occupy();
                    allocated = platform;
                    break;
                }
            }

            if(allocated == null) {
                throw new PlatformUnavailableException(
                        "No Platform Available for " + train.getName());
            }

            System.out.println(train.getName() +
                    " allocated Platform " +
                    allocated.getPlatformNumber());
        }
    }
}