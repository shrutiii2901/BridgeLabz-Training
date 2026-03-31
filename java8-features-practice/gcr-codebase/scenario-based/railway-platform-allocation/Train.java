public class Train implements Comparable<Train> {

    private String name;
    private int arrivalTime;
    private int departureTime;

    public Train(String name, int arrivalTime, int departureTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    @Override
    public int compareTo(Train other) {
        return this.arrivalTime - other.arrivalTime;
    }

    @Override
    public String toString() {
        return name + " Arrival: " + arrivalTime +
               " Departure: " + departureTime;
    }
}