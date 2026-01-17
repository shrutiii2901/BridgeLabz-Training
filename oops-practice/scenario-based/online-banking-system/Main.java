public class Main {
    public static void main(String[] args) {

        Account acc = new SavingsAccount("Shruti", 5000);

        try {
            acc.deposit(2000);
            acc.withdraw(1000);
            acc.showBalance();

            System.out.println("Interest: " + acc.calculateInterest());

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
