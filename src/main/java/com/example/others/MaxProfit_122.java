package com.example.others;

public class MaxProfit_122 {
    private int result = 0;

//    分成多段买卖股票的最佳时机(121)
    //    f(i) = Max(f(min) + prices[i] - prices[min], f(i-1))
    public int maxProfit(int[] prices) {
//        this.flashBack(prices, false, 0, 0, -1);
        int minIndex = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[minIndex]) {
                int current = dp[minIndex] + prices[i] - prices[minIndex];
                dp[i] = current > dp[i - 1] ? current : dp[i - 1];
//                此处重要
                if (prices[i] < prices[i - 1]) {
                    minIndex = i;
                }
            } else if (prices[i] <= prices[minIndex]) {
                minIndex = i;
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    //    回溯超时
    private void flashBack(int[] prices, boolean holding, int sum, int index, int bought) {
        if (sum > this.result) {
            this.result = sum;
        }
        if (index >= prices.length) {
            return;
        }
        if (holding && bought < prices[index]) {
            flashBack(prices, false, sum + prices[index] - bought, index + 1, -1);
            flashBack(prices, true, sum, index + 1, bought);
        }
        if (!holding) {
            if (index < prices.length - 1 && prices[index] < prices[index + 1]) {
                flashBack(prices, true, sum, index + 1, prices[index]);
            } else {
                flashBack(prices, false, sum, index + 1, bought);
            }
        }
    }
}
