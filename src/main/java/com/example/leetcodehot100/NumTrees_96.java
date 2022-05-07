package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

//f[n] 表示n个节点的结果
//dp[i][n] 表示 一共n个节点 此节点为i时的结果
//f[n] = dp[1][n] +...+dp[n][n]
//dp[i][n] = f[i-1]*f[n-i]
public class NumTrees_96 {
    public int numTrees(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i=0;i<=n;i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        int[] f = new int[n+1];
        f[1] = 1;
        f[0] = 1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                dp[j][i] = f[j-1]*f[i-j];
            }
            for (int j=1;j<=i;j++){
                f[i]+=dp[j][i];
            }
        }
        return f[n];
    }
}
