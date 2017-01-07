package package100;

/**
 * Created by jingshanyin on 1/6/17.
 * 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
 transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int profit = 0;
        int low = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // if (prices[i] - prices[i - 1] > 0) {
            //     profit += prices[i] - prices[i - 1];
            //     //low = prices[i];
            // }
            if (prices[i] - prices[i - 1] < 0) {
                profit += prices[i - 1] - low;
                low = prices[i];
            } else {
                if (i == prices.length - 1) {
                    profit += prices[i] - low;
                }
            }
        }
        return profit;
    }
}
