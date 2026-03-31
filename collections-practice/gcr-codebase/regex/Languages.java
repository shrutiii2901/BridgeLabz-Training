import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Languages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but Go too.";
        Pattern p = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
