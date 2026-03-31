import java.util.regex.*;

public class CurrencyExtract {
    public static void main(String[] args) {
        String text = "The price is $45.99 and discount is 10.50";
        Pattern p = Pattern.compile("\\$?\\d+(\\.\\d{2})?");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
