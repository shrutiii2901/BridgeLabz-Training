import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {

        HashMap<String, Integer> votes = new HashMap<>();
        votes.put("Alice", 120);
        votes.put("Bob", 90);
        votes.put("Carol", 150);

        
        LinkedHashMap<String, Integer> orderedVotes = new LinkedHashMap<>(votes);

        
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(votes);

        System.out.println("Votes (Insertion Order): " + orderedVotes);
        System.out.println("Votes (Sorted): " + sortedVotes);
    }
}
