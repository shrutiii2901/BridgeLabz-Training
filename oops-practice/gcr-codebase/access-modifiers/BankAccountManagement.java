import java.util.Scanner;


class BankAccount {
    public String accountNumber;      
    protected String accountHolder;   
    private double balance;           

    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    
    public double getBalance() {
        return balance;
    }

    
    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

   
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    
    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}


class SavingsAccount extends BankAccount {
    private double interestRate;  

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    
    public void displaySavingsAccount() {
        System.out.println("Account Number: " + accountNumber); 
        System.out.println("Account Holder: " + accountHolder); 
        System.out.println("Balance: " + getBalance());        
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}


public class BankAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter details for Bank Account:");
        System.out.print("Account Number: ");
        String accNumber = sc.nextLine();
        System.out.print("Account Holder: ");
        String accHolder = sc.nextLine();
        System.out.print("Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNumber, accHolder, balance);
        System.out.println("\nBank Account Details:");
        account.displayAccount();

       
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        System.out.println("\nUpdated Bank Account Details:");
        account.displayAccount();
        sc.nextLine(); 

       
        System.out.println("\nEnter details for Savings Account:");
        System.out.print("Account Number: ");
        String saNumber = sc.nextLine();
        System.out.print("Account Holder: ");
        String saHolder = sc.nextLine();
        System.out.print("Balance: ");
        double saBalance = sc.nextDouble();
        System.out.print("Interest Rate (%): ");
        double interest = sc.nextDouble();

        SavingsAccount sa = new SavingsAccount(saNumber, saHolder, saBalance, interest);
        System.out.println("\nSavings Account Details:");
        sa.displaySavingsAccount();

    }
}