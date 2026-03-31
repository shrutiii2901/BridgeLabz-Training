@FunctionalInterface
interface LightAction {
    void activate();
}

public class SmartHome {
    public static void main(String[] args) {

        LightAction motionTrigger = () ->
                System.out.println("Lights ON at full brightness due to motion");

        LightAction nightTimeTrigger = () ->
                System.out.println("Lights ON with dim warm light for night");

        LightAction voiceCommandTrigger = () ->
                System.out.println("Lights ON as per voice command");

       
        motionTrigger.activate();
        nightTimeTrigger.activate();
        voiceCommandTrigger.activate();
    }
}
