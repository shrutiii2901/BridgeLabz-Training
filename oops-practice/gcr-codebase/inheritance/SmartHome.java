import java.util.Scanner;

class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Device ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Status (ON/OFF): ");
        String status = sc.nextLine();

        System.out.print("Enter Temperature Setting: ");
        double temp = sc.nextDouble();

        Thermostat t = new Thermostat(id, status, temp);
        t.displayStatus();
    }
}
