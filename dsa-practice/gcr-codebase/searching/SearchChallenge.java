import java.util.*;

public class SearchChallenge {

    static int firstMissingPositive(int[] arr) {
        Arrays.sort(arr);
        int expected = 1;

        for(int num : arr) {
            if(num == expected) expected++;
        }
        return expected;
    }

    static int binarySearch(int[] arr, int target) {
        int left=0,right=arr.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++) arr[i]=sc.nextInt();

        System.out.println("First Missing Positive: " + firstMissingPositive(arr));

        System.out.print("Enter target to search: ");
        int target = sc.nextInt();

        Arrays.sort(arr);
        System.out.println("Target Index: " + binarySearch(arr, target));
    }
}
