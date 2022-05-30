package com.example.leetcodehot100;

public class Rob_198 {
//    动态规划 首先回溯 打劫了i之后 只能打劫i+2或者i+3
//    同理 i只能由i-2或者i-3过来 i-4或者i-一个更大的数字中间可以插一个i-3 所以再之前的都不用考虑了
//    由此可得递推公式 dp[i] = max(dp[i-2],dp[i-3])
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        if (nums.length==3){
            int sum = nums[0] + nums[2];
            return nums[1]>sum ? nums[1] : sum;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int sum = nums[0] + nums[2];
        dp[2] = nums[1]>sum ? nums[1] : sum;
        for (int i=3;i<nums.length;i++){
            dp[i] = nums[i] + (dp[i-2]>dp[i-3] ? dp[i-2] : dp[i-3]);
        }
        return dp[dp.length-1] > dp[dp.length-2] ? dp[dp.length-1] : dp[dp.length-2];
    }

//    个人感觉递归次数太多了方法栈不够用了
    private int flashBack(int[] nums, int max, int index, int temp){
        if (index>=nums.length){
            return temp>max ? temp : max;
        }

        temp += nums[index];
        int sum1 = flashBack(nums,max,index+2,temp);

        int sum2 = flashBack(nums,max,index+3,temp);

        return sum1>sum2 ? sum1 : sum2;
    }
}
