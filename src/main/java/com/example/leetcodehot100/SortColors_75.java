package com.example.leetcodehot100;

import java.util.Random;

public class SortColors_75 {
//生成随机数也要时间
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int begin,int end){
        if (begin>=end){
            return ;
        }
        int tempIndex = getRandom(begin,end);
        int temp = nums[begin];
        nums[begin] = nums[tempIndex];
        nums[tempIndex] = temp;
        temp = nums[begin];
        int index = begin+1;
        for (int i=index;i<=end;i++){
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

    private int getRandom(int begin,int end){
        Random r = new Random();
        int result = r.nextInt(end - begin+1)+begin;
        return result;
    }
}
