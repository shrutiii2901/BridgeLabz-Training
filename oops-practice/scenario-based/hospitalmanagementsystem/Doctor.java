

public class Doctor extends Person implements  HospitalService {
    public Doctor(String name) {
        super(name);
    }

    @Override
    public double calculateConsultationFee() {
        return 500.0;
    }
   
    
}
