package com.example.leetcodeDaily;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountSubarrays_2488 {

//    前缀和暴力求解每一个包含k的子数组 超时
//    3,2,1,4,5 4  从4开始，左边的前缀和，右边的前缀和，左边-1则右边需要1或2，左边-2则右边需要2或3
    public int countSubarrays(int[] nums, int k) {
        int result = 0;
        int currentSum = 0;
        int kIndex = nums.length;
        Map<Integer, Integer> left = new HashMap<>(nums.length);
        Map<Integer, Integer> right = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                nums[i] = 1;
            } else if (nums[i] < k) {
                nums[i] = -1;
            } else {
                nums[i] = 0;
                kIndex = i;
            }
        }
        for (int i = kIndex - 1; i >= 0; i--) {
            currentSum += nums[i];
            Integer leftCount = left.getOrDefault(currentSum, 0);
            leftCount += 1;
            left.put(currentSum, leftCount);
        }
        currentSum = 0;
        for (int i = kIndex + 1; i < nums.length; i++) {
            currentSum += nums[i];
            result += (left.getOrDefault(-currentSum, 0));
            result += (left.getOrDefault(-currentSum+1, 0));
            if (currentSum == 0 || currentSum == 1) {
                result ++;
            }
        }
        result += left.getOrDefault(0,0) + left.getOrDefault(1,0);
        return result + 1;
    }

    private int getRsult(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        int result = 0;
        Set<Map.Entry<Integer, Integer>> entries = a.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer bCount = b.get(-entry.getKey());
            if (bCount != null) {
                result += entry.getValue() * bCount;
            }
            Integer bCount1 = b.get(-entry.getKey() + 1);
            if (bCount1 != null) {
                result += entry.getValue() * bCount1;
            }
        }
        return result;
    }

//    丑陋而且不对
//    private boolean canAddRight = true;
//    private boolean canAddLeft = false;
//    private int result = 1;
//
//
//    public int countSubarrays(int[] nums, int k) {
//        int kIndex = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (k == nums[i]) {
//                kIndex = i;
//                break;
//            }
//        }
//        boolean dfs = dfs(nums, k, kIndex - 1, kIndex + 1, -1);
//        if (dfs) {
//            canAddLeft = !canAddLeft;
//            canAddRight = !canAddRight;
//        }
//        boolean dfs1 = dfs(nums, k, kIndex - 1, kIndex + 1, 1);
//        if (dfs1) {
//            canAddLeft = !canAddLeft;
//            canAddRight = !canAddRight;
//        }
//        dfs(nums, k, kIndex - 1, kIndex + 1, 0);
//        return result;
//    }
//
//    //    -1:left 1:right 0:both
//    private boolean dfs(int[] nums, int k, int leftIndex, int rightIndex, int leftOrRight) {
//        boolean needReverse = false;
//        if (leftIndex < 0 || rightIndex >= nums.length) {
//            return needReverse;
//        }
//        if (leftOrRight == -1) {
//            if (canAddLeft && nums[leftIndex] < k) {
//                result++;
//                canAddLeft = !canAddLeft;
//                canAddRight = !canAddRight;
//                needReverse = true;
//            } else if (canAddRight && nums[leftIndex] > k) {
//                result++;
//                canAddLeft = !canAddLeft;
//                canAddRight = !canAddRight;
//                needReverse = true;
//            } else {
//                return needReverse;
//            }
//        } else if (leftOrRight == 1) {
//            if (canAddLeft && nums[rightIndex] < k) {
//                result++;
//                canAddLeft = !canAddLeft;
//                canAddRight = !canAddRight;
//                needReverse = true;
//            } else if (canAddRight && nums[rightIndex] > k) {
//                result++;
//                canAddLeft = !canAddLeft;
//                canAddRight = !canAddRight;
//                needReverse = true;
//            } else {
//                return needReverse;
//            }
//        } else {
//            if (canAddLeft) {
//                boolean needReturn = true;
//                if (canAddLeft && nums[rightIndex] < k) {
//                    result++;
//                    canAddLeft = !canAddLeft;
//                    canAddRight = !canAddRight;
//                    needReverse = true;
//                    needReturn = false;
//                }
//                if (canAddRight && nums[rightIndex] > k) {
//                    result++;
//                    canAddLeft = !canAddLeft;
//                    canAddRight = !canAddRight;
//                    needReverse = needReverse == false;
//                    needReturn = false;
//                }
//                if (needReturn) {
//                    return needReverse;
//                }
//            } else {
//                boolean needReturn = true;
//                if (canAddRight && nums[rightIndex] > k) {
//                    result++;
//                    canAddLeft = !canAddLeft;
//                    canAddRight = !canAddRight;
//                    needReverse = true;
//                    needReturn = false;
//                }
//                if (canAddLeft && nums[rightIndex] < k) {
//                    result++;
//                    canAddLeft = !canAddLeft;
//                    canAddRight = !canAddRight;
//                    needReverse = needReverse == false;
//                    needReturn = false;
//                }
//                if (needReturn) {
//                    return needReverse;
//                }
//            }
//        }
//        boolean dfs = dfs(nums, k, leftIndex - 1, rightIndex, -1);
//        if (dfs) {
//            canAddLeft = !canAddLeft;
//            canAddRight = !canAddRight;
//        }
//        boolean dfs1 = dfs(nums, k, leftIndex, rightIndex + 1, 1);
//        if (dfs1) {
//            canAddLeft = !canAddLeft;
//            canAddRight = !canAddRight;
//        }
//        boolean dfs2 = dfs(nums, k, leftIndex - 1, rightIndex + 1, 0);
//        if (dfs2) {
//            canAddLeft = !canAddLeft;
//            canAddRight = !canAddRight;
//        }
//        return needReverse;
//    }
}
