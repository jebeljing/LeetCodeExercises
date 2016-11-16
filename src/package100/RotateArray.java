package package100;

/**
 * Created by jingshanyin on 11/15/16.
 * 189. Rotate Array
 *
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        k = k% len;
        if (k == 0) return;
        int temp;

        ////loop 1, reverse the whole array
        for (int i = 0; i < len / 2; i++) {
            temp = nums[i];
            nums[i] = nums[len - 1 - i];
            nums[len - 1 - i] = temp;
        }
        //loop 2, reverse the first k elements
        for (int i = 0; i < k/2; i++) {
            temp = nums[i];
            nums[i] = nums[k - 1 - i];
            nums[k - 1 - i] = temp;
        }
        //loop 3, reverse the remaining elements
        for (int i = k; i < (len - k)/2 + k; i++) {
            temp = nums[i];
            nums[i] = nums[len - 1 - i + k];
            nums[len - 1 - i + k] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length == 0 || k % nums.length == 0) return;
        k %= nums.length;
        int done = 0;
        for (int i = 0; i < k; i++) {
            int j = i;
            int tempVal = nums[i];
            while (done < nums.length) {
                int tempJ = (j + k) % nums.length;       // next location
                int temp = nums[tempJ];
                nums[tempJ] = tempVal;
                tempVal = temp;
                j = tempJ;
                done++;
                if (j == i) break;   // about to go to a visitd location.
            }
        }
    }
}
