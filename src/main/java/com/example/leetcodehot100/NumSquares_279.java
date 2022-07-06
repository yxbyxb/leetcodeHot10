package com.example.leetcodehot100;

public class NumSquares_279 {
    public int numSquares(int n) {
//        dp[i] = 1 + dp[i-j*j] j从1~根号i
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = 1 + dp[i-j*j];
                min = min < dp[i] ? min : dp[i];
            }
            dp[i] = min;
        }
        return dp[n];
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }
}
