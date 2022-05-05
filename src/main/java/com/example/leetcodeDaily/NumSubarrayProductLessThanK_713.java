package com.example.leetcodeDaily;

//耻辱之滑动窗口
public class NumSubarrayProductLessThanK_713 {
//    暴力，惨不忍睹
//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int result = 0;
//        for (int i=0;i<nums.length;i++){
//            int product = 1;
//            for (int j=i;j<nums.length;j++){
//                product*=nums[j];
//                if (product<k){
//                    result++;
//                }else {
//                    break;
//                }
//            }
//        }
//        return result;
//    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<1){
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = 0;
        int product = 1;
        for (;right<nums.length;right++){
            product *= nums[right];
            for (;product>=k;){
                product/=nums[left];
                left++;
            }
            result += right-left+1;
        }
        return result;
    }

//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int n = nums.length, ret = 0;
//        int prod = 1, i = 0;
//        for (int j = 0; j < n; j++) {
//            prod *= nums[j];
//            while (i <= j && prod >= k) {
//                prod /= nums[i];
//                i++;
//            }
//            ret += j - i + 1;
//        }
//        return ret;
//    }
}
