import java.util.*;


interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double calculateInterest();
}


abstract class Account implements BankService {
    protected int accountNumber;
    protected String holderName;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);
    }

    public synchronized void transfer(Account target, double amount)
            throws InsufficientBalanceException {
        this.withdraw(amount);
        target.deposit(amount);
        transactionHistory.add("Transferred " + amount + " to Account " + target.accountNumber);
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        System.out.println("Transaction History for Account " + accountNumber);
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}


class SavingsAccount extends Account {

    SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }
}


class CurrentAccount extends Account {

    CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.01; // 1% interest
    }
}


class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}


class TransactionTask extends Thread {
    private Account account;
    private double amount;
    private boolean isDeposit;

    TransactionTask(Account account, double amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    public void run() {
        try {
            if (isDeposit) {
                account.deposit(amount);
                System.out.println("Deposited " + amount + " | Balance: " + account.getBalance());
            } else {
                account.withdraw(amount);
                System.out.println("Withdrawn " + amount + " | Balance: " + account.getBalance());
            }
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

// ===================== MAIN CLASS =====================
public class OnlineBankingSystem {

    public static void main(String[] args) {

        Account savings = new SavingsAccount(101, "Shruti", 5000);
        Account current = new CurrentAccount(102, "Amit", 3000);

        // Concurrent transactions
        Thread t1 = new TransactionTask(savings, 1000, true);
        Thread t2 = new TransactionTask(savings, 2000, false);
        Thread t3 = new TransactionTask(current, 500, true);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();

            savings.transfer(current, 1000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFinal Balances:");
        System.out.println("Savings Balance: " + savings.getBalance());
        System.out.println("Current Balance: " + current.getBalance());

        System.out.println("\nInterest:");
        System.out.println("Savings Interest: " + savings.calculateInterest());
        System.out.println("Current Interest: " + current.calculateInterest());

        savings.showTransactions();
        current.showTransactions();
    }
}
