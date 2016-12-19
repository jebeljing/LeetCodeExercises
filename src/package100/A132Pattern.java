package package100;

import java.util.Arrays;

/**
 * Created by jingshanyin on 12/18/16.
 * 132 Pattern
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

 Note: n will be less than 15,000.

 Example 1:
 Input: [1, 2, 3, 4]

 Output: False

 Explanation: There is no 132 pattern in the sequence.
 Example 2:
 Input: [3, 1, 4, 2]

 Output: True

 Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 Example 3:
 Input: [-1, 3, 2, 0]

 Output: True

 Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class A132Pattern {

    //n

    /*
    III. Optimized O(n) solution

As I mentioned, to further reduce the time complexity, we need to record the "useful" information about elements in the right part of the input array nums. Since these elements are located at the right part of nums, it will be hard to do so if we are scanning the array from the beginning. So the idea is to scan it from the end while in the meantime keep track of the "useful" information. But still at each index j, we need to know the minimum element for subarray nums[0, j). This can be done by doing a pre-scan in the forward direction and memorize the results for each index in an auxiliary array (we will call the array as arr whose element arr[j] will denote the minimum element in the subarray nums[0, j)).

Until now we are kinda vague about the exact meaning of "useful" information, so let's try to be more specific. Assume we're currently scanning (from the end) the element with index j, our task is to find two elements nums[i] and nums[k] to determine if there exists a 132 pattern, with i < j < k. The left element nums[i], as it has been shown in part II, will be chosen as arr[j], the minimum element of subarray nums[0, j). What about the right element nums[k]?

The answer to that will address the meaning of "useful" information. First note we are only interested in elements that are greater than arr[j], so it is sensible to maintain only those elements. Second, among all these qualified elements, which one will be the most probable to fall into the range (nums[i], nums[j])? I would say it is the smallest one (i.e., if the smallest one is out of the range, all others will also be out of range). So to sum up, the "useful" information for current index j will be a collection of scanned elements that are greater than arr[j], and nums[k] will be chosen as the smallest one if the collection is not empty.

From the analyses above, it looks like we have to do some sorting stuff for the retained elements (or at least find a way to figure out its smallest element). Well, it turns out these elements will be sorted automatically due to the fact that arr[j'] >= arr[j] as long as j' < j. Here is how it goes, which is a proof by induction.

At the beginning we have an empty collection and of course it is sorted. Now suppose we are at index j and the corresponding collection is still sorted, let's see if it remains so at index j - 1. First we will check if nums[j] is greater than arr[j]. If not, we simply continue to j - 1. Since the collection is intact so it will be sorted at j - 1. Otherwise, we need to remove elements in the collection that are no greater than arr[j] (this is necessary because some smaller elements may be left over in the collection from previous steps). After removal, we then compare the first element in the collection with nums[j] to see if a 132 pattern has been found, provided the collection is not empty. If so, return true. Otherwise one of the following must be true: the collection is empty or nums[j] is no greater than the first element in the collection. In either case the collection is sorted. Now if we have arr[j - 1] < nums[j], we need to add nums[j] to the collection since it is a qualified number for arr[j - 1]. Again in either case the collection will remain sorted after addition (if it is empty, after addition there is only one element; otherwise since the added element is no greater than the first element in the collection before addition, it will become the new first element after addition and the collection stays sorted).

Here is the program with O(n) time and space complexity. There is one minor optimization based on the observation that the total number of elements in the collection will never exceed the total number of elements scanned so far. Therefore the right part of the arr array can be used to serve as the collection. For time complexity, each element in the input array nums will be pushed into and popped out from the collection (or stack to be exact) at most once, the time complexity will be O(n) despite of the nested loop.
     */
    public boolean find132pattern3(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j]) continue;
            while (top < nums.length && arr[top] <= arr[j]) top++;
            if (top < nums.length && nums[j] > arr[top]) return true;
            arr[--top] = nums[j];
        }

        return false;
    }

    //n^2

    /*
    II. Improved O(n^2) solution

To reduce the time complexity down to O(n^2), we need to do some observations. In the naive solution above, let's assume we have index j fixed, what should index i be so that it is most probable we will have a 132 pattern? Or in other words, what should i be so that we will be certain there is no such 132 pattern for combination (*, j, *) whenever there is no 132 pattern for combination of (i, j, *)? (Here * means any index before or after index j.)

The answer lies in the fact that once the first two numbers nums[i] and nums[j] are fixed, we are up to find the third number nums[k] which will be within the range (nums[i], nums[j]) (the two bounds are exclusive). Intuitively the larger the range is, the more likely there will be a number "falling into" it. Therefore we need to choose index i which will maximize the range (nums[i], nums[j]). Since the upper bound nums[j] is fixed, this is equivalent to minimizing the lower bound nums[i]. Thus it is clear i should be the index of the minimum element of the subarray nums[0, j) (left inclusive, right exclusive).

Since we are scanning index j from the beginning of the input array nums, we can keep track of the minimum element of the subarray from index 0 up to j - 1 without rescanning it. Therefore the first two loops in the naive solution can be combined into one and leads to the following O(n^2) solution:
     */
    public boolean find132pattern2(int[] nums) {
        for (int j = 0, min = Integer.MAX_VALUE; j < nums.length; j++) {
            min = Math.min(nums[j], min);
            if (min == nums[j]) continue;

            for (int k = nums.length - 1; k > j; k--) {
                if (min < nums[k] && nums[k] < nums[j]) return true;
            }
        }

        return false;
    }


    //n^3

    /*
    I. Naive O(n^3) solution

The naive O(n^3) solution is a no-brainer --- simply check every (i, j, k) combination to see if there is any 132 pattern.

public boolean find132pattern(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
            }
        }
    }
    return false;
}
And of course it will get rejected due to TLE. So let's see how we can do better.
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] >= nums[j]) break;
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] > nums[k] && nums[k] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
