package package300;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Jebeljing on 12/23/2016.
 * 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    public static void main(String... args) {
        CoinChange test = new CoinChange();
        System.out.println(test.coinChange(new int[]{1,2,5}, 100));
        System.out.println("end");
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null) return -1;
        if (amount == 0) return 0;

        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        int result = 0;
        int countLevel = 0;
        while(!queue.isEmpty()) {
            if (countLevel == 0) {
                countLevel = queue.size();
                result++;
            }
            countLevel--;
            Integer target = queue.poll();

            for (int coin: coins) {
                if (target - coin > 0 && !set.contains(target-coin)) {
                    set.add(target - coin);
                    queue.offer(target - coin);
                } else if (target - coin == 0) {
                    return result;
                }
            }
        }
        return -1;
    }
}
