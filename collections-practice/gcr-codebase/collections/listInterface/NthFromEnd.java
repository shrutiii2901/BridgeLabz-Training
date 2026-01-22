import java.util.*;

public class NthFromEnd {

    public static String findNthFromEnd(LinkedList<String> list, int n) {
        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

       
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                return "Invalid N";
            }
            fast.next();
        }

        
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> input = new LinkedList<>();
        input.add("A");
        input.add("B");
        input.add("C");
        input.add("D");
        input.add("E");

        System.out.println(findNthFromEnd(input, 2)); 
    }
}
