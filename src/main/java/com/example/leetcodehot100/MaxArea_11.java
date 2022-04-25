package com.example.leetcodehot100;

public class MaxArea_11 {
//    暴力 超时
//    public int maxArea(int[] height) {
//        int result = 0;
//        int lastMaxHeightI = 0;
//        for (int i=0;i<height.length-1;i++){
//            if (height[i]>lastMaxHeightI){
//                int lastMaxHeightJ = 0;
//                for (int j=height.length-1;j>i;j--){
//                    if(height[j]>lastMaxHeightJ){
//                        int temp = (j-i)*Math.min(height[i],height[j]);
//                        if (temp>result){
//                            result = temp;
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }

//    动态规划 第i个最大值为Max(max，当前和之前最高的) 错误
//    public int maxArea(int[] height) {
//        int result = 0;
//        int lastMaxHeightIndex = 0;
//        result = Math.min(height[0],height[1]);
//        lastMaxHeightIndex = height[0]>height[1]?0:1;
//        for (int i = 1;i<height.length;i++){
//            result = Math.max(result,Math.min(height[lastMaxHeightIndex],height[i])*(i-lastMaxHeightIndex));
//        }
//        return result;
//    }

//    双指针 + 优化 只有当当前的min(i,j)>之前的min(i,j)才需要比较
//    执行用时：2 ms, 在所有 Java 提交中击败了97.97%的用户
//    内存消耗：51.9 MB, 在所有 Java 提交中击败了8.31%的用户
    public int maxArea(int[] height) {
        int result = 0;
        int lastMin = 0;
        for(int i=0,j=height.length-1;i<j;){
            if (height[i]<height[j]){
                if (height[i]>lastMin){
                    lastMin = height[i];
                    result = Math.max(result,(j-i)*lastMin);
                }
                i++;
            }else{
                if (height[i]>lastMin){
                    lastMin = height[j];
                    result = Math.max(result,(j-i)*lastMin);
                }
                j--;
            }
        }
        return result;
    }
}
