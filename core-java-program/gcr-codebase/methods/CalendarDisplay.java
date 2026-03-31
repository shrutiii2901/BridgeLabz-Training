import java.util.Scanner;

public class CalendarDisplay {

    static String[] months = {"Jan","Feb","Mar","Apr","May","Jun",
                              "Jul","Aug","Sep","Oct","Nov","Dec"};
    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }

    static int firstDay(int m, int y) {
        int d = 1;
        y -= (14 - m) / 12;
        int x = y + y/4 - y/100 + y/400;
        m += 12 * ((14 - m) / 12) - 2;
        return (d + x + (31*m)/12) % 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt() - 1;
        int year = sc.nextInt();

        if (month == 1 && isLeap(year)) days[1] = 29;

        System.out.println(months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int start = firstDay(month + 1, year);
        for (int i = 0; i < start; i++) System.out.print("    ");

        for (int d = 1; d <= days[month]; d++) {
            System.out.printf("%3d ", d);
            if ((d + start) % 7 == 0) System.out.println();
        }
    }
}
