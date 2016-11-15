package package100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jingshanyin on 11/14/16.
 * 169. Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (map.keySet().contains(nums[i])) {
                int count = map.get(nums[i]) + 1;
                if (count > nums.length /2 )
                    return nums[i];
                else
                    map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }

    public int majorityElement2(int[] nums)
    {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
