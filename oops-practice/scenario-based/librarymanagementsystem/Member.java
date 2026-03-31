public class Member extends User implements FineCalculator {

    public Member(String name) {
        super(name);
    }

    @Override
    public double calculateFine(int days) {
        return days * 2;
    }
}
