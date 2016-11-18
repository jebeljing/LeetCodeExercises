package package200;

/**
 * Created by Jebeljing on 11/17/2016.
 * 283. Move Zeroes
 *
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (num == 0) {
                zeroes++;
            } else if (zeroes != 0) {
                nums[i - zeroes] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
