package com.example.leetcodehot100;

import java.util.*;

public class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j=i+1,k=nums.length-1;j<k;){
                if (j>i+1&&nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if (k<nums.length-1&&nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                if (nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                } else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                }
            }
        }
        return result;
    }
}
