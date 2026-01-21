import java.util.*;

class TrafficManager {

    private VehicleNode head = null;

   
    private Queue<String> waitingQueue = new LinkedList<>();
    private final int MAX_QUEUE_SIZE = 5;

    private Scanner sc = new Scanner(System.in);

    
    public void addVehicleToQueue() throws QueueOverflowException {
        if (waitingQueue.size() == MAX_QUEUE_SIZE)
            throw new QueueOverflowException("Waiting queue is full");

        System.out.print("Enter vehicle number: ");
        String vehicle = sc.next();
        waitingQueue.add(vehicle);
        System.out.println("Vehicle added to waiting queue");
    }

    
    public void enterRoundabout() throws QueueUnderflowException {
        if (waitingQueue.isEmpty())
            throw new QueueUnderflowException("No vehicles in waiting queue");

        String vehicle = waitingQueue.poll();
        VehicleNode newNode = new VehicleNode(vehicle);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            VehicleNode temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("🚗 Vehicle entered roundabout: " + vehicle);
    }

    
    public void exitRoundabout() {
        if (head == null) {
            System.out.println(" No vehicles in roundabout");
            return;
        }

        if (head.next == head) {
            System.out.println("Vehicle exited: " + head.vehicleNumber);
            head = null;
            return;
        }

        VehicleNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        System.out.println("Vehicle exited: " + head.vehicleNumber);
        temp.next = head.next;
        head = head.next;
    }

 
    public void displayState() {
        System.out.println("Roundabout Vehicles:");
        if (head == null) {
            System.out.println("Empty");
        } else {
            VehicleNode temp = head;
            do {
                System.out.print(temp.vehicleNumber + " → ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("(Back to Start)");
        }

        System.out.println("Waiting Queue: " + waitingQueue);
    }
}