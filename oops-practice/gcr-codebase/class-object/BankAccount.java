import java.util.Scanner;

class BankAccount {

    String accountHolder;
    String accountNumber;
    double balance;

    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount acc = new BankAccount();

        System.out.print("Enter Account Holder Name: ");
        acc.accountHolder = sc.nextLine();

        System.out.print("Enter Account Number: ");
        acc.accountNumber = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        acc.balance = sc.nextDouble();

        System.out.println("\nWelcome " + acc.accountHolder);
        acc.displayBalance();

        System.out.print("\nEnter amount to deposit: ");
        double dep = sc.nextDouble();
        acc.deposit(dep);

        System.out.print("\nEnter amount to withdraw: ");
        double wd = sc.nextDouble();
        acc.withdraw(wd);

        sc.close();
    }
}
