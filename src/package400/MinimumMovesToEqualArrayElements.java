package package400;

/**
 * Created by Jebeljing on 11/21/2016.
 * 453. Minimum Moves to Equal Array Elements
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

 */
public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += (nums[i] - min);
        }
        return result;
    }
}
