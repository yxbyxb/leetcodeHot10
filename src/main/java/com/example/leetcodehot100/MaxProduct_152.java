package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.List;

public class MaxProduct_152 {
//    比表达的动态规划还快
    public int maxProduct(int[] nums) {

//        List<Integer> indexOfZero = new ArrayList<>();
//        for (int i=0;i<nums.length;i++){
//            if (nums[i]==0){
//                indexOfZero.add(i);
//            }
//        }
//        if (indexOfZero.isEmpty()){
//            return findSubMaxProduct(nums,0,nums.length-1);
//        }
//        int result = 0;
//        int first = findSubMaxProduct(nums,0,indexOfZero.get(0)-1);
//        result = result>first ? result : first;
//
//        int last = findSubMaxProduct(nums,indexOfZero.get(indexOfZero.size()-1)+1,nums.length-1);
//        result = result>last ? result : last;
//
//
//        for (int i=0;i<indexOfZero.size()-1;i++){
//            int temp = findSubMaxProduct(nums,indexOfZero.get(i)+1,indexOfZero.get(i+1)-1);
//            result = result>temp ? result : temp;
//        }

        int[] indexOfZero = new int[50];
        int index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                indexOfZero[index++] = i;
            }
        }

        if (index==0){
            return findSubMaxProduct(nums,0,nums.length-1);
        }

        int result = 0;
        int first = findSubMaxProduct(nums,0,indexOfZero[0]-1);
        result = result>first ? result : first;

        int last = findSubMaxProduct(nums,indexOfZero[index-1]+1,nums.length-1);
        result = result>last ? result : last;


        for (int i=0;i<index-1;i++){
            int temp = findSubMaxProduct(nums,indexOfZero[i]+1,indexOfZero[i+1]-1);
            result = result>temp ? result : temp;
        }


        return result;
    }

    private int findSubMaxProduct(int[] nums, int start, int end){
        if (start>end){
            return 0;
        }
        if (start==end){
            return nums[start];
        }
        int result = 1;
        for (int i=start;i<=end;i++){
            result*=nums[i];
        }
        if (result<0){
            int result1 = result;
            for (int i=start;i<=end;i++){
                result1/=nums[i];
                if (nums[i]<0){
                    break;
                }
            }
            int result2 = result;
            for (int i=end;i>=start;i--){
                result2/=nums[i];
                if (nums[i]<0){
                    break;
                }
            }
            result = result1>result2 ? result1 : result2;
        }
        return result;
    }
}
