package package200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jingshanyin on 1/5/17.
 * 229. Majority Element II
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

 Hint:

 How many majority elements could it possibly have?
 */
public class MajorityElementII {


    //The basic idea is based on Moore's Voting Algorithm, we need two candidates with top 2 frequency.
    // If meeting different number from the candidate, then decrease 1 from its count,
    // or increase 1 on the opposite condition. Once count equals 0, then switch the candidate to the current number.
    // The trick is that we need to count again for the two candidates after the first loop.
    // Finally, output the numbers appearing more than n/3 times.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int count[] = new int[2];
        int x[] = new int[2];
        x[0] = 0;
        x[1] = 1;

        for (int i = 0; i < nums.length; i++) {
            if (x[0] == nums[i]) {
                count[0]++;
            } else if (x[1] == nums[i]) {
                count[1]++;
            } else if (count[0] == 0) {
                x[0] = nums[i];
                count[0] = 1;
            } else if (count[1] == 0) {
                x[1] = nums[i];
                count[1] = 1;
            } else {
                count[0]--;
                count[1]--;
            }
        }

        Arrays.fill(count, 0);
        for (int i: nums) { //// Count again for x1, x2
            if (i == x[0]) count[0]++;
            else if (i == x[1]) count[1]++;
        }

        for (int j = 0; j < 2; j++) {
            if (count[j] > nums.length/3 && !res.contains(x[j])) res.add(x[j]);
        }
        return res;
    }
}
