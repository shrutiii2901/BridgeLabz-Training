import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        System.out.println("Sorted List: " + list);
    }
}
