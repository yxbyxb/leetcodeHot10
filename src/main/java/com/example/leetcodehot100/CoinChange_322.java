package com.example.leetcodehot100;

import java.util.Arrays;

public class CoinChange_322 {
//    输入：coins = [1, 2, 5], amount = 11
//    输出：3
//    解释：11 = 5 + 5 + 1

//    dp[i][j]表示前i个数和为j最小情况
//    dp[i][j] = min(n + dp[i-1][j-n*coins[j]])
//    dp[i] = dp[i-coins[j]]+1
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i=1;i<dp.length;i++){
            for (int j=coins.length-1;j>=0;j--){
                if (i-coins[j]>=0){
                    int temp = dp[i-coins[j]]+1;
                    dp[i] = temp < dp[i] ? temp : dp[i];
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 回溯超时了....
     * */
//    private int result = Integer.MAX_VALUE;
//
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0){
//            return 0;
//        }
//        flashBack(coins,0,amount,0,0);
//        return this.result==Integer.MAX_VALUE||this.result==0?-1:this.result;
//    }
//
//    private void flashBack(int[] coins, int index, int amount, int sum, int count){
//        if (index>=coins.length||sum>amount){
//            return;
//        }
//        if (amount==sum){
//            this.result = this.result>count ? count : this.result;
//            return;
//        }
//        sum+=coins[index];
//        flashBack(coins,index,amount,sum,count+1);
//        sum-=coins[index];
//        flashBack(coins,index+1,amount,sum,count);
//    }
}
