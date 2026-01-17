import java.util.*;

public class MatrixBinary {

    static boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int left = 0, right = r*c-1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            int val = matrix[mid/c][mid%c];

            if(val == target) return true;
            else if(val < target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int matrix[][] = new int[r][c];

        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                matrix[i][j] = sc.nextInt();

        int target = sc.nextInt();

        System.out.println(searchMatrix(matrix, target));
    }
}
