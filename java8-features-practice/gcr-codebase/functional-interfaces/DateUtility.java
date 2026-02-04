import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtil {

    static String format(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

public class DateUtility {
    public static void main(String[] args) {
        System.out.println(DateUtil.format(LocalDate.now()));
    }
}
