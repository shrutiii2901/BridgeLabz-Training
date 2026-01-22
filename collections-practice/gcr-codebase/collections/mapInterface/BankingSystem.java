import java.util.*;

class Withdrawal {
    int accountNumber;
    int amount;

    Withdrawal(int accountNumber, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        // AccountNumber -> Balance
        HashMap<Integer, Integer> accounts = new HashMap<>();
        accounts.put(101, 5000);
        accounts.put(102, 8000);
        accounts.put(103, 3000);

        // Sort customers by balance
        TreeMap<Integer, Integer> sortedByBalance = new TreeMap<>();
        for (int acc : accounts.keySet()) {
            sortedByBalance.put(accounts.get(acc), acc);
        }

        System.out.println("Accounts Sorted by Balance: " + sortedByBalance);

        // Withdrawal queue
        Queue<Withdrawal> queue = new LinkedList<>();
        queue.add(new Withdrawal(101, 1000));
        queue.add(new Withdrawal(103, 500));

        while (!queue.isEmpty()) {
            Withdrawal w = queue.remove();
            accounts.put(w.accountNumber,
                    accounts.get(w.accountNumber) - w.amount);
        }

        System.out.println("Final Balances: " + accounts);
    }
}
