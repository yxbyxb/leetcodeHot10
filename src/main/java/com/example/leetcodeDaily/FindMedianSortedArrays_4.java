package com.example.leetcodeDaily;

public class FindMedianSortedArrays_4 {
//    复杂度m+n 二分可以优化为 log(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int length = nums1.length+nums2.length;
        int mid1;
        int mid2;
        if (length%2==0){
            mid1 = length/2-1;
            mid2 = length/2;
        }else {
            mid1 = length/2;
            mid2 = length/2;
        }
        int index1=0;
        int index2=0;
        int i=0;
        for (;i<=mid2&&index1<nums1.length&&index2<nums2.length;i++){
            if (i==mid1||i==mid2){
                if (nums1[index1]<nums2[index2]){
                    result+=nums1[index1++];
                }else {
                    result+=nums2[index2++];
                }
            }else{
                if (nums1[index1]<nums2[index2]){
                    index1++;
                }else {
                    index2++;
                }
            }
        }

        if (index1==nums1.length){
            for (;index2<nums2.length;i++){
                if (i==mid1||i==mid2){
                    result+=nums2[index2++];
                }else {
                    index2++;
                }
            }
        }
        if (index2==nums2.length){
            for (;index1<nums1.length;i++){
                if (i==mid1||i==mid2){
                    result+=nums1[index1++];
                }else {
                    index1++;
                }
            }
        }

        if (length%2!=0){
            return result;
        }
        return result/2;
    }
}
