package com.example.leetcodeDaily;

public class CountVowelStrings_1641 {
    //    n=1 1+ 1+ 1+1+1
//    n=2 5+ 4+ 3+2+1
//    n=3 15+10+6+3+1
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = sum(dp, i, j);
            }
        }
        return sum(dp,n,5);
    }

    private int sum(int[][] dp, int i, int j) {
        int sum = 0;
        for (int k = 0; k < j; k++) {
            sum += dp[i - 1][k];
        }
        return sum;
    }
}
