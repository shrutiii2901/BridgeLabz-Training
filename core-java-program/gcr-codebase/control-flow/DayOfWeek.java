public class DayOfWeek {

    public static void main(String[] args) {

        
        int month = Integer.parseInt(args[0]); // month
        int day = Integer.parseInt(args[1]);   // day
        int year = Integer.parseInt(args[2]);  // year

        
        int adjustedYear = year - (14 - month) / 12;

        int x = adjustedYear
                + adjustedYear / 4
                - adjustedYear / 100
                + adjustedYear / 400;

        int adjustedMonth = month + 12 * ((14 - month) / 12) - 2;

        int dayOfWeek = (day + x + (31 * adjustedMonth) / 12) % 7;

        
        System.out.println(dayOfWeek);
    }
}