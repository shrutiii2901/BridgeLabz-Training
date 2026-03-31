import java.util.*;

class ElectionServiceImpl implements ElectionService {

    private Map<Integer, Voter> voters = new HashMap<>();
    private Map<Integer, Candidate> candidates = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    
    public void registerVoter() {
        System.out.print("Enter Voter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Voter Name: ");
        String name = sc.nextLine();

        voters.put(id, new Voter(id, name));
        System.out.println(" Voter registered successfully");
    }

    
    public void addCandidate() {
        System.out.print("Enter Candidate ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Candidate Name: ");
        String name = sc.nextLine();

        candidates.put(id, new Candidate(id, name));
        System.out.println("Candidate added successfully");
    }

    
    public void castVote() throws DuplicateVoteException {
        System.out.print("Enter Voter ID: ");
        int voterId = sc.nextInt();

        System.out.print("Enter Candidate ID: ");
        int candidateId = sc.nextInt();

        Voter voter = voters.get(voterId);
        Candidate candidate = candidates.get(candidateId);

        if (voter == null || candidate == null) {
            System.out.println("Invalid voter or candidate ID");
            return;
        }

        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter has already voted");
        }

        candidate.addVote();
        voter.markVoted();
        System.out.println("✅ Vote cast successfully");
    }

    
    public void displayResults() {
        System.out.println("Election Results");
        for (Candidate c : candidates.values()) {
            System.out.println(c.getName() + " → " + c.getVoteCount() + " votes");
        }
    }
}