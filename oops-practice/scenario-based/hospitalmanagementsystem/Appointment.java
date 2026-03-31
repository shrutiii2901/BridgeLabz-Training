public class Appointment {
    Doctor doctor;

    public Appointment(Doctor doctor) {
        this.doctor = doctor;
    }

    public void book() throws AppointmentNotAvailableException {
    
        if (doctor==null) {
            throw new AppointmentNotAvailableException("No appointment slots available with Dr. " + doctor.name);
        }
        System.out.println("Appointment booked with Dr. " + doctor.name);
    }


}
