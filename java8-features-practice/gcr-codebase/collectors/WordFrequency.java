import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {

        String paragraph = "java streams are powerful and java streams are useful";

        Map<String, Integer> wordCount =
                Arrays.stream(paragraph.split("\\s+"))
                        .collect(Collectors.toMap(
                                word -> word,
                                word -> 1,
                                Integer::sum
                        ));

        System.out.println(wordCount);
    }
}
