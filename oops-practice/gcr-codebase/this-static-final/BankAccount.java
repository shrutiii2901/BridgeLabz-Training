public class BankAccount {

    private static String bankName = "State bank of India";
    private static int totalAccounts = 0;

    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total number of accounts: " + totalAccounts);
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public static void main(String[] args) {

        BankAccount a1 = new BankAccount("Lynda Princy", "ACC12345", 1000);
        BankAccount a2 = new BankAccount("Prince Danish", "ACC67890", 500);

        System.out.println("\nAccount 1 Details:");
        a1.displayAccountDetails();

        System.out.println("\nAccount 2 Details:");
        a2.displayAccountDetails();

        BankAccount.getTotalAccounts();

        System.out.println("\nPerforming transactions on Account 1:");
        a1.deposit(200);
        a1.withdraw(150);
        a1.displayAccountDetails();

        a2.deposit(100);
        a2.withdraw(800);
    }
}
