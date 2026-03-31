public abstract class Account implements BankService {
    protected String accountHolder;
    protected double balance;

    public Account(String name, double balance) {
        this.accountHolder = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient Balance");
        balance -= amount;
    }

    public void showBalance() {
        System.out.println("Balance: " + balance);
    }
}
