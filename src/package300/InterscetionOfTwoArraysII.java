package package300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jebeljing on 11/28/2016.
 * 350. Intersection of Two Arrays II
 *
 *  Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Follow up:

 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
public class InterscetionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

        List<Integer> list = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] result = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            result[index] = list.get(index);
        }
        return result;
    }

}
