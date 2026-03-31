import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class EVChargingSystem {

    public static void main(String[] args) throws NoChargingSlotAvailableException {

   
        Map<Integer, ChargingSlot> slots = new HashMap<>();
        slots.put(1, new ChargingSlot(1));
        slots.put(2, new ChargingSlot(2));

    
        Queue<Vehicle> waitingQueue = new LinkedList<>();

        PricingStrategy strategy = new PeakPricing();
        // PricingStrategy strategy = new NormalPricing();

      
        Vehicle v1 = new Vehicle("EV101", 10);
        Vehicle v2 = new Vehicle("EV102", 8);
        Vehicle v3 = new Vehicle("EV103", 12);

        try {
            assignVehicle(v1, slots, waitingQueue, strategy);
            assignVehicle(v2, slots, waitingQueue, strategy);
            assignVehicle(v3, slots, waitingQueue, strategy);
        } catch (NoChargingSlotAvailableException e) {
            System.out.println("Exception: " + e.getMessage());
        }

     
        ChargingSlot slot1 = slots.get(1);
        slot1.releaseSlot();
        System.out.println("\nSlot 1 is now free.");

        if (!waitingQueue.isEmpty()) {
            Vehicle nextVehicle = waitingQueue.poll();
            assignVehicle(nextVehicle, slots, waitingQueue, strategy);
        }
    }


    public static void assignVehicle(Vehicle vehicle,
                                     Map<Integer, ChargingSlot> slots,
                                     Queue<Vehicle> queue,
                                     PricingStrategy strategy)
            throws NoChargingSlotAvailableException {

        for (ChargingSlot slot : slots.values()) {
            if (!slot.isOccupied()) {

                slot.assignSlot();

                double bill = strategy.calculatePrice(vehicle.getUnitConsumed());

                System.out.println("Vehicle " + vehicle.getVehicleNumber()
                        + " assigned to Slot " + slot.getSlotID());
                System.out.println("Bill Amount: ₹" + bill);

                return;
            }
        }

       
    queue.add(vehicle);
        throw new NoChargingSlotAvailableException(
                "No slot available. Vehicle added to waiting queue: "
                        + vehicle.getVehicleNumber());
    }
}
