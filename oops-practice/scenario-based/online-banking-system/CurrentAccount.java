public class CurrentAccount extends Account {

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }
}
