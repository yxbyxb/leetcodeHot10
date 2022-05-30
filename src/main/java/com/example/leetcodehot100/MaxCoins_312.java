package com.example.leetcodehot100;

import java.util.Arrays;

//贪心 通过11个样例 错误 应用动态规划 改日再刷
public class MaxCoins_312 {
    public int maxCoins(int[] nums) {
        int result=0;
        int[] clone = nums.clone();
        int length = nums.length;
        int[] border = new int[2];
        int borderIndex = 0;
        quickSort(clone,0,clone.length-1);
        for (int i=0;i<clone.length;i++){
            int index = lineSearch(nums,clone[i]);
            if (length>2&&(isBorder(index,nums))){
                border[borderIndex] = nums[index];
                borderIndex++;
            }else {
                result+=multiply(index,nums);
            }
        }
        result+=border[0]*border[1];
        result+=border[0]>border[1] ? border[0] : border[1];
        return result;
    }

    private boolean isBorder(int index,int[] nums){
        int left = findLeft(index,nums);
        int right = findRight(index,nums);
        if (left==1||right==1){
            return true;
        }
        return false;
    }

    private int multiply(int index,int[] nums){
        int result;
        int left = findLeft(index,nums);
        int right = findRight(index,nums);
        result = left*nums[index]*right;
        nums[index] = -1;
        return result;
    }

    private int findLeft(int index,int[] nums){
        int result = 1;
        if (index==0){
            result = 1;
        }else {
            for (int i = index-1;i>=0;i--){
                if (nums[i]!=-1){
                    result = nums[i];
                    break;
                }
            }
        }
        return result;
    }

    private int findRight(int index,int[] nums){
        int result = 1;
        if (index==nums.length-1){
            result = 1;
        }else {
            for (int i = index+1;i<nums.length;i++){
                if (nums[i]!=-1){
                    result = nums[i];
                    break;
                }
            }
        }
        return result;
    }

    private void quickSort(int[] nums,int begin,int end){
        if (begin>=end){
            return;
        }
        int temp = nums[begin];
        Arrays.sort(nums);
        int index = begin+1;
        for (int i = index;i<=end;i++){
            if (nums[i]<temp){
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                index++;
            }
        }
        nums[begin] = nums[index-1];
        nums[index-1] = temp;
        quickSort(nums,begin,index-2);
        quickSort(nums,index,end);
    }

    private int lineSearch(int[] nums,int target){
        for (int i=0;i<nums.length;i++){
            if (target==nums[i]){
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums,int target,int begin,int end){
        if (begin>end){
            return -1;
        }
        int result;
        int mid = (begin+end)/2;
        if (nums[mid]==target){
            result = mid;
        }else if (target<nums[mid]&&target>=nums[begin]){
            result = binarySearch(nums,target,begin,mid-1);
        }else if (target>nums[mid]&&target<=nums[end]){
            result = binarySearch(nums,target,mid+1,end);
        }else{
            result = -1;
        }
        return result;
    }
}
