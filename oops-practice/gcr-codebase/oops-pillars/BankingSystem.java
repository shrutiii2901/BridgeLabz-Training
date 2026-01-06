
abstract class BankAccount {
    private String accountNumber;
    protected double balance;

    public BankAccount(String accNo, double balance) {
        this.accountNumber = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }

    public void applyForLoan() {
        System.out.println("Loan applied");
    }

    public double calculateLoanEligibility() {
        return balance * 5;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc = new SavingsAccount("12345", 10000);
        System.out.println("Interest: " + acc.calculateInterest());
    }
}
