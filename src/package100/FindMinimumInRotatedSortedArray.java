package package100;

/**
 * Created by yinj on 1/18/2017.
 * 153. Find Minimum in Rotated Sorted Array.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low < high) {
            mid = low + (high - low)/2;
            if (nums[mid] <= nums[high]) {
                high = mid;
            } else if (nums[mid] >= nums[low]) {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
