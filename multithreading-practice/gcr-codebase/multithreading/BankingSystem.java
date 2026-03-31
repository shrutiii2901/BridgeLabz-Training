class BankAccount {
    private int balance = 10000;

    
    public void withdraw(String customer, int amount) {
        System.out.println("[" + customer + "] Attempting to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("Transaction successful: " + customer +
                    ", Amount: " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Transaction failed for " + customer + " (Insufficient balance)");
        }
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private String customer;
    private int amount;

    public Transaction(BankAccount account, String customer, int amount) {
        this.account = account;
        this.customer = customer;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(customer, amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        int[] amounts = {3000, 4000, 2000, 5000, 1500};

        for (int i = 0; i < amounts.length; i++) {
            Thread t = new Thread(new Transaction(account, "Customer-" + (i + 1), amounts[i]),
                    "Customer-" + (i + 1));
            System.out.println(t.getName() + " state: " + t.getState());
            t.start();
        }
    }
}
