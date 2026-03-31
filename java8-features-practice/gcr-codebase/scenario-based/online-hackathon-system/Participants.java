import java.util.*;
import java.time.*;
public class Participants {
    
    private String name;
    private Map<String, Boolean> testResults;
    private int score;
    private LocalDateTime submissionTime;

    public Participants(String name, Map<String, Boolean> testResults, LocalDateTime submissionTime, LocalDateTime deadline )throws LateSubmissionException{
        if(submissionTime.isAfter(deadline)){
            throw new LateSubmissionException("Submission is late for : " + name);
        }

        this.name = name;
        this.testResults=testResults;
        this.submissionTime=submissionTime;
        calculateScore();

        
    }
    private int calculateScore(){
        score =0;
        for(Boolean result : testResults.values()){
            if(result){
                score++;
            }
        }
        return score;
    }

    public int getScore(){
        return calculateScore();
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Name : " +name+ " Score : " +score;
    }


}
