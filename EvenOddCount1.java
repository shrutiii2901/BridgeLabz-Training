import java.util.*;
public class EvenOddCount1 {
    public static void evenAndOddCount(int n , int arr[]){
      int evenCount=0;
      int oddCount=0;
      for(int i =0; i<n; i++){
        if(arr[i]%2==0){
            evenCount ++;
        }else{
            oddCount++;
        }
        System.out.println("The even length is" + evenCount);
        System.out.println("The odd length is" + oddCount);
      }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n;i++ ){
            arr[i]= sc.nextInt();
        }

        evenAndOddCount(n, arr);
    }
}