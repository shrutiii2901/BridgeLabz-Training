import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSortedArray sol = new MergeSortedArray();

        System.out.print("Enter m: ");
        int m = sc.nextInt();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        System.out.println("Enter elements of nums1 (first " + m + " elements):");
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        sol.merge(nums1, m, nums2, n);

        System.out.println("Merged array:");
        System.out.println(Arrays.toString(nums1));

        sc.close();
    }
}
