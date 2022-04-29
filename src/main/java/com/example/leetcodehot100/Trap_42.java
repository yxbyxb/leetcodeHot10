package com.example.leetcodehot100;

public class Trap_42 {
    //动态规划 i位置的接水量=Math.min(leftMax[i],rightMax[i])-height[i]
//    public int trap(int[] height) {
//        int result = 0;
//        int[] leftMax = new int[height.length];
//        int[] rightMax = new int[height.length];
//        leftMax[0] = 0;
//        rightMax[rightMax.length-1] = 0;
//        int max = 0;
//        for (int i=1;i<height.length;i++){
//            leftMax[i] = Math.max(height[i-1],max);
//            max = leftMax[i];
//        }
//        max = 0;
//        for (int i = height.length-2;i>=0;i--){
//            rightMax[i] = Math.max(height[i+1],max);
//            max = rightMax[i];
//        }
//
//        for (int i = 1;i<height.length-1;i++){
//            int temp = Math.min(leftMax[i],rightMax[i])-height[i];
//            if (temp>0){
//                result+=temp;
//            }
//        }
//        return result;
//    }
//    双指针 动态规划的优化 伯分伯
    public int trap(int[] height) {
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        for (int i=0,j=height.length-1;i<j;){
            if (leftMax<=rightMax){
                int temp = leftMax-height[i];
                if (temp>0){
                    result += temp;
                }
                leftMax = Math.max(leftMax,height[i]);
                i++;
            }else {
                int temp = rightMax-height[j];
                if (temp>0){
                    result += temp;
                }
                rightMax = Math.max(rightMax,height[j]);
                j--;
            }
        }
        return result;
    }
}
