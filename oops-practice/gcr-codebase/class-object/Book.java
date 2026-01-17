
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
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    
    public static void main(String[] args) {

        BankAccount acc = new BankAccount();

        acc.accountHolder = "State of Chennai";
        acc.accountNumber = "ACC001";
        acc.balance = 700.0;

        System.out.println("State of Chennai\n");

        acc.displayBalance();
        acc.deposit(200.0);
        acc.withdraw(100.0);
        
        acc.withdraw(1000.0);   
    }
}