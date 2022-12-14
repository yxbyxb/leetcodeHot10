package com.example.others;

import java.util.HashSet;
import java.util.Set;

public class MaxSum_1537 {
    public int maxSum(int[] nums1, int[] nums2) {
        int end1 = 0;
        int end2 = 0;
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (; end1 < nums1.length && end2 < nums2.length; ) {
            if (nums1[end1] < nums2[end2]) {
                sum1 += nums1[end1];
                end1++;
            } else if (nums1[end1] > nums2[end2]) {
                sum2 += nums2[end2];
                end2++;
            } else {
                sum += sum1 > sum2 ? sum1 : sum2;
                sum += nums1[end1];
                end1++;
                end2++;
                sum1 = 0;
                sum2 = 0;
            }
        }

        for (; end1 < nums1.length; end1++) {
            sum1 += nums1[end1];
        }
        for (; end2 < nums2.length; end2++) {
            sum2 += nums2[end2];
        }
        sum += sum1 > sum2 ? sum1 : sum2;
        int result = (int) (sum % (Math.pow(10, 9)+7));
        return result;
    }
}
