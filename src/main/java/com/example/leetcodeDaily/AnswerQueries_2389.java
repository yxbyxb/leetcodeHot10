package com.example.leetcodeDaily;

import java.util.Arrays;

public class AnswerQueries_2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] preSum = new int[nums.length + 1];
        int[] result = new int[queries.length];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int currentLength = 0;
            for (int j = 1; j < preSum.length; j++) {
                if (preSum[j] <= queries[i]) {
                    currentLength++;
                } else {
                    break;
                }
            }
            result[i] = currentLength;
        }
        return result;
    }
}
