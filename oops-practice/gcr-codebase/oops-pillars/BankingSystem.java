import java.util.Scanner;

abstract class BankAccount {
    private String accountNumber;
    protected double balance;

    public BankAccount(String accNo, double balance) {
        this.accountNumber = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    public abstract double calculateInterest();

    public String getAccountNumber() {
        return accountNumber;
    }
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
        System.out.println("Loan applied for account: " + getAccountNumber());
    }

    public double calculateLoanEligibility() {
        return balance * 5;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Number:");
        String accNo = sc.nextLine();

        System.out.println("Enter Initial Balance:");
        double balance = sc.nextDouble();

        SavingsAccount acc = new SavingsAccount(accNo, balance);

        System.out.println("Enter amount to deposit:");
        double depositAmount = sc.nextDouble();
        acc.deposit(depositAmount);

        System.out.println("Current Balance: " + acc.balance);

        double interest = acc.calculateInterest();
        System.out.println("Interest earned: " + interest);

        acc.applyForLoan();
        System.out.println("Loan Eligibility Amount: " + acc.calculateLoanEligibility());

        sc.close();
    }
}
