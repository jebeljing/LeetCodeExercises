package package300;

/**
 * Created by yinj on 1/12/2017.
 * 319. Bulb Switcher
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

 Example:

 Given n = 3.

 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);

         /* if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = ; j <= i/2; j++) {
                if (i % j == 0) {
                    temp++;

                }
            }
            dp[i] = dp[i -1] + temp%2;
        }
        return dp[n];*/
    }
}
