public class Platform {

    private int platformNumber;
    private boolean available;

    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.available = true;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void occupy() {
        available = false;
    }

    public void release() {
        available = true;
    }
}