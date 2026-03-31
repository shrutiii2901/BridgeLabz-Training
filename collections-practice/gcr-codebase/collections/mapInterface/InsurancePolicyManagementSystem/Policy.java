import java.time.LocalDate;

class Policy {
    int policyNumber;
    String holderName;
    LocalDate expiryDate;

    Policy(int policyNumber, String holderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | " + expiryDate;
    }
}
