package com.example.leetcodehot100;

import java.util.Arrays;

public class TwoSum_1 {
    public static int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        int[] temp = nums.clone();
        Arrays.sort(temp);
//        if (temp[0]+temp[temp.length-1]==target){
//            result[0] = temp[0];
//            result[1] = temp[temp.length-1];
//            return temp;
//        }
        for (int i=0,j=temp.length-1;i<j;){
//            if (temp[i]==temp[i-1]){
//                i++;
//                continue;
//            }
//            if (temp[j]==temp[j+1]){
//                j--;
//                continue;
//            }
            if (temp[i]+temp[j]>target){
                j--;
            } else if (temp[i]+temp[j]<target){
                i++;
            } else {
                result[0] = lineSearch(nums,temp[i]);
                result[1] = reLineSearch(nums,temp[j]);
                break;
            }
        }
        return result;
    }

    private static int lineSearch(int[] nums,int num){
        for (int i=0;i<nums.length;i++){
            if (nums[i]==num){
                return i;
            }
        }
        return -1;
    }

    private static int reLineSearch(int[] nums,int num){
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]==num){
                return i;
            }
        }
        return -1;
    }

}
