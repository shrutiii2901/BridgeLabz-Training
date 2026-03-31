interface SmartDevices {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevices {

    public void turnOn() {
        System.out.println("Turning ON Light");
    }

    public void turnOff() {
        System.out.println("Turning OFF Light");
    }
}

class AC implements SmartDevices {

    public void turnOn() {
        System.out.println("Turning ON AC");
    }

    public void turnOff() {
        System.out.println("Turning OFF AC");
    }
}

class TV implements SmartDevices {

    public void turnOn() {
        System.out.println("Turning ON TV");
    }

    public void turnOff() {
        System.out.println("Turning OFF TV");
    }
}

public class SmartDevice {
    public static void main(String[] args) {

        SmartDevices light = new Light();
        SmartDevices ac = new AC();
        SmartDevices tv = new TV();

        light.turnOn();
        light.turnOff();

        ac.turnOn();
        ac.turnOff();

        tv.turnOn();
        tv.turnOff();
    }
}
