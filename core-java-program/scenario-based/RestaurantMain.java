import java.util.*;

class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}


class Table {
    int tableNumber;

    Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}


class Reservation {
    int tableNumber;
    String timeSlot;

    Reservation(int tableNumber, String timeSlot) {
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
    }
}


class RestaurantReservationSystem {

    Map<Integer, Table> tables = new HashMap<>();
    List<Reservation> reservations = new ArrayList<>();

   
    void addTable(int tableNumber) {
        tables.put(tableNumber, new Table(tableNumber));
    }


    void reserveTable(int tableNumber, String timeSlot) throws TableAlreadyReservedException {
        for (Reservation r : reservations) {
            if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }
        reservations.add(new Reservation(tableNumber, timeSlot));
        System.out.println("Table " + tableNumber + " reserved for " + timeSlot);
    }

    void cancelReservation(int tableNumber, String timeSlot) {
        reservations.removeIf(r -> r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot));
        System.out.println("Reservation cancelled for Table " + tableNumber);
    }

    
    void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");
        for (int tableNumber : tables.keySet()) {
            boolean reserved = false;
            for (Reservation r : reservations) {
                if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                    reserved = true;
                    break;
                }
            }
            if (!reserved) {
                System.out.println("Table " + tableNumber);
            }
        }
    }
}


public class RestaurantMain {
    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();

        system.addTable(1);
        system.addTable(2);
        system.addTable(3);

        try {
            system.reserveTable(1, "7PM");
            system.reserveTable(2, "7PM");
            system.reserveTable(1, "7PM"); 
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        system.showAvailableTables("7PM");
        system.cancelReservation(1, "7PM");
        system.showAvailableTables("7PM");
    }
}
