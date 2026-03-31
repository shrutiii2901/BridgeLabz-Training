
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class OnlineHackhathonSystem {

    public static void main(String[] args) {
        List<Participants> participant = new ArrayList<>();

        LocalDateTime deadline = LocalDateTime.of(2026, 2, 17, 12, 0);

        try {

            Map<String, Boolean> result1 = new HashMap<>();
            result1.put("TestCase1", true);
            result1.put("TestCase2", false);
            result1.put("TestCase3", true);
            participant.add(new Participants("Krati", result1,  LocalDateTime.of(2026, 2, 17, 11, 0), deadline));

            Map<String, Boolean> result2 = new HashMap<>();
            result2.put("TestCase1", true);
            result2.put("TestCase2", true);
            result2.put("TestCase3", true);
            participant.add(new Participants("Shruti", result2,  LocalDateTime.of(2026, 2, 17, 12, 30), deadline));

            Map<String, Boolean> result3 = new HashMap<>();
            result3.put("TestCase1", false);
            result3.put("TestCase2", false);
            result3.put("TestCase3", false);
            participant.add(new Participants("Ayushi", result3,  LocalDateTime.of(2026, 2, 17, 10, 30), deadline));

        } catch (LateSubmissionException e) {
            System.out.println("Exception : " + e.getMessage());
        }

        participant.sort(Comparator.comparing(Participants::getScore).reversed());

        System.out.println("LeaderBoard");

        int rank =1;
        for(Participants p : participant){
            System.out.println("Rank" +rank+ "-" +p);
            rank++;
        }

    }
}
