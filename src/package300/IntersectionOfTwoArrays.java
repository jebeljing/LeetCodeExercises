package package300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jingshanyin on 11/20/16.
 * 349. Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> tempSet = new HashSet<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                tempSet.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
                continue;
            } else {
                j++;
                continue;
            }
        }
        int [] result = new int[tempSet.size()];
        int index = 0;
        for (int val : tempSet) {
            result[index] = val;
            index++;
        }
        return result;
    }
}
