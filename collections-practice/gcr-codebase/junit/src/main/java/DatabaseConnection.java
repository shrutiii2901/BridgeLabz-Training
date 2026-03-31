public class DatabaseConnection {
    boolean connected = false;

    void connect() {
        connected = true;
    }

    void disconnect() {
        connected = false;
    }
}
