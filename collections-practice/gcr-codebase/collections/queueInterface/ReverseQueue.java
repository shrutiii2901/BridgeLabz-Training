import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        Queue<Integer> temp = new LinkedList<>();

        while (!q.isEmpty()) {
            int x = q.remove();
            Queue<Integer> helper = new LinkedList<>();
            while (!temp.isEmpty()) {
                helper.add(temp.remove());
            }
            temp.add(x);
            while (!helper.isEmpty()) {
                temp.add(helper.remove());
            }
        }

        System.out.println("Reversed Queue: " + temp);
    }
}
