interface MedicalRecord {
    void addRecord(String diagnosis);
    void viewRecords();
}

abstract class Patient {

   
    private int patientId;
    private String name;
    private int age;

    
    private String diagnosis;

    Patient(int id, String name, int age) {
        this.patientId = id;
        this.name = name;
        this.age = age;
    }

    
    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    
    abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge = 2000;

    InPatient(int id, String name, int age, int days) {
        super(id, name, age);
        this.daysAdmitted = days;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String diagnosis) {
        setDiagnosis(diagnosis);
    }

    public void viewRecords() {
        System.out.println("Diagnosis: " + getDiagnosis());
    }
}

class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee = 500;

    OutPatient(int id, String name, int age) {
        super(id, name, age);
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String diagnosis) {
        setDiagnosis(diagnosis);
    }

    public void viewRecords() {
        System.out.println("Diagnosis: " + getDiagnosis());
    }
}

public class HospitalManagement {

    public static void main(String[] args) {

        
        Patient p1 = new InPatient(101, "Riya", 22, 5);
        Patient p2 = new OutPatient(102, "Aditya", 30);

        p1.getPatientDetails();
        System.out.println("Bill: ₹" + p1.calculateBill());

        p2.getPatientDetails();
        System.out.println("Bill: ₹" + p2.calculateBill());
    }
}