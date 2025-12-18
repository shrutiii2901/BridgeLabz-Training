import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int minLenWindow = Integer.MAX_VALUE;
        int currentSum = 0;
        int low = 0;

        for (int high = 0; high < n; high++) {
            currentSum += nums[high];

            while (currentSum >= target) {
                minLenWindow = Math.min(minLenWindow, high - low + 1);
                currentSum -= nums[low];
                low++;
            }
        }

        System.out.println(minLenWindow == Integer.MAX_VALUE ? 0 : minLenWindow);
    }
}
