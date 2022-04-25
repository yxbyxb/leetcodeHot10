package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindDisappearedNumbers_448 {
    public static void main(String[] args) {
        System.out.println(FindDisappearedNumbers_448.binarySearch(new int[]{1,2,2,3,3,4,7,8},4));
//        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

//    bitmap 100%
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] bitmap = new boolean[nums.length+1];
        for (int i=0;i<nums.length;i++){
            bitmap[nums[i]] = true;
        }
        bitmap[0] = true;
        for (int i=1;i<=nums.length;i++){
            if (!bitmap[i]){
                result.add(i);
            }
        }

        return result;
    }

//    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> result = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 1;i<=nums.length;i++){
//            if (!binarySearch(nums,i)){
//                result.add(i);
//            }
//        }
//        return result;
//    }
    //    二分查找 打败5.78
    private static boolean binarySearch(int[] nums,int num){
        boolean result = false;
        int index = nums.length/2;
        int start = 0;
        int end = nums.length;
        for (;index>=start&&index<end;){
            if (num>nums[end-1]||num<nums[start]){
                break;
            }
            if (nums[index]==num){
                result = true;
                break;
            }else if(nums[index]>num){
                end = index;
                index = (index+start) / 2;
            }else{
                start = index;
                index = (index+end)/2;
            }
        }
        return result;
    }
}
