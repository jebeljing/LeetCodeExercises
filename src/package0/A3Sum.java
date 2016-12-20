package package0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jebeljing on 11/28/2016.
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 */
public class A3Sum {

    public List<List<Integer>> threeSum(int[] num) {
        if (num == null) return null;
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int left = i + 1, right = num.length - 1;
                while (left < right) {
                    int sum = num[i] + num[left] + num[right];
                    if (sum < 0) {
                        while (left < right && num[left] == num[left + 1])left++;
                        left++;
                    } else if (sum > 0) {
                        while (left < right && num[right] == num[right - 1]) right--;
                        right--;
                    } else {
                        res.add(Arrays.asList(num[i], num[left], num[right]));
                        while(left < right && num[left] == num[left+ 1]) left++;
                        while(left< right && num[right] == num[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
