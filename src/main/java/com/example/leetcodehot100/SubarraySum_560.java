package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubarraySum_560 {


    /**
     * sum[i]表示0~i的和 sum[i] = sum[i-1]+nums[i]
     * i~j的和 = sum[i]-sum[j] + nums[j] = sum[i] - sum[j-1]
     * k = sum[i] - sum[j-1]
     * sum[i] = k + sum[j-1]
     */
    public int subarraySum(int[] nums, int k) {
        int lastSum = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            lastSum+=nums[i];
            Integer integer = map.get(lastSum - k);
            if (integer!=null) {
                count+=integer;
            }
            map.put(lastSum,map.getOrDefault(lastSum,0)+1);
        }
        return count;
    }

//    为什么不能直接put k呢 因为map存的是0~k的 直接put是 x~k的
//    public int subarraySum(int[] nums, int k) {
//        int lastSum = 0;
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            lastSum+=nums[i];
//            if (map.get(lastSum-k)!=null) {
//                map.put(k,map.getOrDefault(k,0)+1);
//            }
//            map.put(lastSum,map.getOrDefault(lastSum,0)+1);
//        }
//        return map.getOrDefault(k,0);
//    }

    /**
     * 超出内存限制
     * dp[i].get(j)表示从i开始长度为j的和
     * dp[i].get(j) = dp[i].get(j-1)+nums[i+j-1]
     * */
//    int result = 0;
//    public int subarraySum(int[] nums, int k) {
//        List<Integer>[] dp = new List[nums.length];
//        for (int i=0;i< nums.length;i++){
//            dp[i] = new ArrayList<>(nums.length-i+1);
//            for (int j=0;j<nums.length-i+1;j++){
//                dp[i].add(0);
//            }
//        }
//        for (int i=0;i< nums.length;i++){
//            dp[i].set(1,nums[i]) ;
//            if (dp[i].get(1)==k){
//                this.result+=1;
//            }
//        }
//        for (int j=2;j<=nums.length;j++){
//            for (int i=0;i+j-1< nums.length;i++){
//                dp[i].set(j,dp[i].get(j-1)+nums[i+j-1]);
//                if (dp[i].get(j)==k){
//                    this.result+=1;
//                }
//            }
//        }
//        return this.result;
//    }
}
