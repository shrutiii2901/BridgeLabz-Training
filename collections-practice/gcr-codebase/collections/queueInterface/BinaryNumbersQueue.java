import java.util.*;

public class BinaryNumbersQueue {
    public static void main(String[] args) {

        int N = 5;
        Queue<String> q = new LinkedList<>();

        q.add("1");

        for (int i = 1; i <= N; i++) {
            String current = q.remove();
            System.out.print(current + " ");

            q.add(current + "0");
            q.add(current + "1");
        }
    }
}
