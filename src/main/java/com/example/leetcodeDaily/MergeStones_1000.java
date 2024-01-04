package com.example.leetcodeDaily;

import java.util.LinkedList;
import java.util.List;

public class MergeStones_1000 {
    //    双指针，每次都找k个连续数字，和最小的合并
    public int mergeStones(int[] stones, int k) {
        if (stones.length==0){
            return 0;
        }
        if (k == 1 || (stones.length - k) % (k - 1) != 0) {
            return -1;
        }
        int result = 0;
        List<Integer> myStones = new LinkedList<>();
        for (int stone : stones) {
            myStones.add(stone);
        }
        while (myStones.size() > 1) {
            int minStart = 0;
            int tempStart = 0;
            int minSum = Integer.MAX_VALUE;
            for (; tempStart + k - 1 < myStones.size(); tempStart++) {
                int currentSum = 0;
                for (int kCount = 0; kCount < k; kCount++) {
                    currentSum += myStones.get(tempStart + kCount);
                }
                if (currentSum < minSum) {
                    minStart = tempStart;
                    minSum = currentSum;
                }
            }
            for (int kCount = 0; kCount < k - 1; kCount++) {
                myStones.remove(minStart);
            }
            myStones.set(minStart, minSum);
            result += minSum;
        }
        return result;
    }
//    public int mergeStones(int[] stones, int k) {
//        if (k == 1 || stones.length < k || (stones.length - k) % (k - 1) != 0) {
//            return -1;
//        }
//        int result = 0;
//        int arrayStart = 0;
//        int arrayEnd = stones.length - 1;
//        int forTimes = 1 + (stones.length - k) / (k - 1);
//        for (int forTime = 0; forTime < forTimes; forTime++) {
//            int start = 0;
//            int end = k - 1;
//            int tempStart = arrayStart;
//            int tempEnd = arrayStart;
//            int minSum = Integer.MAX_VALUE;
//            int currentSum = 0;
//            for (; tempEnd < stones.length; ) {
//                for (int kCount = 0; kCount < k; kCount++) {
//                    currentSum += stones[tempEnd];
//
//                }
//            }
//        }
//        return result;
//    }
//
//    private int getAfterIncrementIndex(int[] stones, int index) {
//        index++;
//        for (; index < stones.length; index++) {
//            if (stones[index] > 0) {
//                break;
//            }
//        }
//        return index;
//    }
}
