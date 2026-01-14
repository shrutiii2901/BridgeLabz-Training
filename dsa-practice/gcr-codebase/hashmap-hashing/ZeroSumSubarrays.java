import java.util.HashMap;

class ZeroSumSubarrays {

    static void findZeroSumSubarrays(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0 || map.containsKey(sum)) {
                System.out.println("Zero sum subarray found ending at index " + i);
            }
            map.put(sum, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2};
        findZeroSumSubarrays(arr);
    }
}
