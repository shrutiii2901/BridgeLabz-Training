public class Main {

    public static void main(String[] args) {

        RailwayStation station = new RailwayStation(3);

        station.addTrain(new Train("Train A", 900, 1000));
        station.addTrain(new Train("Train B", 930, 1030));
        station.addTrain(new Train("Train C", 945, 1100));
        station.addTrain(new Train("Train D", 950, 1130));

        try {
            station.allocatePlatforms();
        }
        catch (PlatformUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }
}