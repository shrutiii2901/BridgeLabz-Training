import java.util.*;

public class DataStructureSearchComparison {

    public static void main(String[] args) {

        int N = 1000000;
        int[] arr = new Random().ints(N, 0, N).toArray();

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int value : arr) {
            hashSet.add(value);
            treeSet.add(value);
        }

        int target = arr[N / 2];

        long start = System.nanoTime();
        for (int x : arr) if (x == target) break;
        long end = System.nanoTime();
        System.out.println("Array Search Time: " + (end - start));

        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start));

        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start));
    }
}
