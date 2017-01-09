package package300;

/**
 * Created by jingshanyin on 1/8/17.
 * 343. Integer Break;
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.

 Hint:

 There is a simple O(n) solution to this problem.
 You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; i - j >= 2 && i - j >= j; j++) {
                int temp = Math.max(dp[i - j] * j, (i - j) * j);
                if (temp > dp[i]) {
                    dp[i] = temp;
                }
            }
            //dp[i] = Math.max(dp[i - 1] * 1, (i - 1) * 10);
            //2 1 1 2
        }

        return dp[n];
    }
}
