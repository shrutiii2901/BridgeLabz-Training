// HospitalManagement.java
abstract class Patient {
    private int id;
    protected String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    public InPatient(int id, String name) {
        super(id, name);
    }

    public double calculateBill() {
        return 5000;
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Patient p = new InPatient(1, "Ravi");
        System.out.println("Bill: " + p.calculateBill());
    }
}
