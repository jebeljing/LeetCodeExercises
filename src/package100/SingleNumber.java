package package100;

import java.util.Arrays;

/**
 * Created by jingshanyin on 11/18/16.
 * 136. Single Number
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0]
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i= i+ 2) {
            if (nums[i] != nums[i + 1])
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}
