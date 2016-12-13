package package400;

import java.util.Arrays;

/**
 * Created by jingshanyin on 12/12/16.
 * 462. Minimum Moves to Equal Array Elements II
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

 You may assume the array's length is at most 10,000.

 Example:

 Input:
 [1,2,3]

 Output:
 2

 Explanation:
 Only two moves are needed (remember each move increments or decrements one element):

 [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            count += nums[end] - nums[start];
            start++;
            end--;
        }
        return count;
    }
}
