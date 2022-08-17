package com.example.leetcodehot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanPartition_416 {
    /**
     * dp[i][j]表示前i个数里和为j是否为真
     * dp[i][j] = dp[i-1][j-nums[i]]
     * */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int biggest = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (nums[i]>biggest){
                biggest = nums[i];
            }
        }
        if (sum%2!=0){
            return false;
        }
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length][target+1];
        if (nums[0]<target+1){
            dp[0][nums[0]] = true;
        }
        for (int i=0;i<nums.length;i++){
            dp[i][0] = true;
        }
        for (int i=1;i<nums.length;i++){
            for (int j=1;j<target+1;j++){
                if (dp[i-1][j]||(j-nums[i]>=0&&dp[i-1][j-nums[i]])){
                    if (j==target){
                        return true;
                    }
                    dp[i][j] = true;
                }
            }
        }
        return false;
    }

//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int i=0;i<nums.length;i++){
//            sum+=nums[i];
//        }
//        if (sum%2!=0){
//            return false;
//        }
//        int target = sum/2;
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length-1;
//        return flashBack(nums,left,right,0,target);
//    }

//    回溯又超时我草你妈
    private boolean flashBack(int[] nums,int left,int right,int sum,int target){
        if (left>right){
            return false;
        }
        if (sum==target){
            return true;
        }
        boolean result1 = flashBack(nums,left+1,right,sum+nums[left],target);
        if (result1){
            return true;
        }
        boolean result2 = flashBack(nums,left,right-1,sum+nums[right],target);
        if (result2){
            return true;
        }
        boolean result3 = flashBack(nums,left+1,right-1,sum,target);
        if (result3){
            return true;
        }
        return false;
    }
}
