import java.util.*;

public class RotateList {

    public static List<Integer> rotateList(List<Integer> list, int rotateBy) {
        int size = list.size();
        rotateBy = rotateBy % size;

        List<Integer> rotated = new ArrayList<>();

        for (int i = rotateBy; i < size; i++) {
            rotated.add(list.get(i));
        }

        for (int i = 0; i < rotateBy; i++) {
            rotated.add(list.get(i));
        }

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);

        List<Integer> result = rotateList(input, 2);
        System.out.println(result);
    }
}
