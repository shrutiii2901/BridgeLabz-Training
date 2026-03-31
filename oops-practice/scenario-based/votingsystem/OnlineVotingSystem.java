import java.util.*;

public class OnlineVotingSystem {
    public static void main(String[] args) {

        ElectionService service = new ElectionServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("ONLINE VOTING SYSTEM ");
            System.out.println("1. Register Voter");
            System.out.println("2. Add Candidate");
            System.out.println("3. Cast Vote");
            System.out.println("4. Display Results");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> service.registerVoter();
                    case 2 -> service.addCandidate();
                    case 3 -> service.castVote();
                    case 4 -> service.displayResults();
                    case 5 -> {
                        System.out.println("Exiting system...");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice");
                }
            } catch (DuplicateVoteException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}