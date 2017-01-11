package package200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinj on 1/11/2017.
 * 216. Combination Sum III
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        helper(k, n, 1, result, new ArrayList<Integer>());
        return result;
    }

    private void helper(int k, int n, int start, List<List<Integer>> result, List<Integer> tempResult) {
        // if (k < 0 || k > 9 || n < 0 || n > 45) return;
        if (0 == k && n == 0) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        for (int i = start; i <= 9; i++) {
            tempResult.add(i);
            helper(k - 1, n - i, i + 1, result, tempResult);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}
