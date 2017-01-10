package package300;

/**
 * Created by jingshanyin on 1/9/17.
 * 378. Kth Smallest Element in a Sorted Matrix.
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementInASortedMatrix {

    /*
    * Main loop is binary search of max - min.
Swap from left-bottom to right-top can get count <= mid in O(n) time instead of O(nlogn), total complexity will be O(nlogm) while m = max - min.*/
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low)/2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int result = 0;
        int i = n - 1;
        int j = 0;
        while (i >=0 && j < n) {
            if (matrix[i][j] > mid) {
                i--;
            } else {
                result = result + i + 1;
                j++;
            }
        }
        return result;
    }
}
