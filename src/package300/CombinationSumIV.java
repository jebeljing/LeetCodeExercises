package package300;

import java.util.Arrays;

/**
 * Created by yinj on 1/13/2017.
 * 377. Combination Sum IV.
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.
 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSumIV {
    int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1 ) {
            return dp[target];
        }

        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                result += helper(nums, target - nums[i]);
            }
        }
        dp[target] = result;
        return dp[target];
    }

    /*Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {

        if (target < 0) return 0;
        else if (target == 0) return 1;
        Arrays.sort(nums);
        int result = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                 temp = combinationSum4(nums, target - nums[i]);
            } else {
                temp = map.get(target- nums[i]);
            }
           result += temp;

        }
        return result;
    }*/
}
