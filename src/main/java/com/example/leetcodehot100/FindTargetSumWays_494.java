package com.example.leetcodehot100;

public class FindTargetSumWays_494 {


    /**
     * 问题转化 假设全都是正数 把一个数变成负的就是sum-2*nums[i]
     * 求添加正负号为target 也就是找到几个符号 负数的和为 negSum
     * sum-2*negSum = target negSum=(sum-target)/2
     * 可得sum-target必须为偶数
     * dp[i][j]表示前i个数和为j的数目
     * dp[i][j] = dp[i-1][j-nums[i]]+dp[i-1][j]
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if (sum<target||(sum-target)%2!=0){
            return 0;
        }
        int negSum = (sum-target)/2;
        int[][] dp = new int[nums.length+1][negSum+1];
        dp[0][0] = 1;
        for (int i=1;i<nums.length+1;i++){
            for (int j=0;j<negSum+1;j++){
                dp[i][j] = dp[i - 1][j];
                if (j-nums[i-1]>=0){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][negSum];
    }

    /**
     * 回溯
     * */
//    public int findTargetSumWays(int[] nums, int target) {
//        int sum = 0;
//        for (int i=0;i<nums.length;i++){
//            sum+=nums[i];
//        }
//        if (sum<target||(sum-target)%2!=0){
//            return 0;
//        }
//        return flashBack(nums,0,target,0,0);
//    }
//
//    private int flashBack(int[] nums, int index, int target, int sum, int result) {
//        if (index >= nums.length) {
//            return (target == sum) ? 1 : 0;
//        }
//        sum += nums[index];
//        result += flashBack(nums,index+1,target,sum,0);
//
//        sum -= nums[index]*2;
//        result += flashBack(nums,index+1,target,sum,0);
//
//        return result;
//    }
}
