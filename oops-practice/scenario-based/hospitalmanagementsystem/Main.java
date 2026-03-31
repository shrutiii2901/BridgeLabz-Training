
public class Main {
    public static void main(String[] args) {
     Doctor d = new Doctor("Shukla");
     Appointment a = new Appointment(d);
     try {
         a.book();
         System.out.println("Consultation Fee: " + d.calculateConsultationFee());
     } catch (AppointmentNotAvailableException e) {
         System.out.println(e.getMessage());
     }        
    }
}
