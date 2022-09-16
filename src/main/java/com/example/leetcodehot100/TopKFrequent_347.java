package com.example.leetcodehot100;

import java.util.*;

public class TopKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> integers = map.keySet();
        Integer[] temp = new Integer[integers.size()];
        int i=0;
        for (Integer num : integers){
            temp[i++] = num;
        }
        Arrays.sort(temp, (a, b) -> {
            int getA = map.get(a);
            int getB = map.get(b);
            return Integer.compare(getB, getA);
        });
        int[] result = new int[k];
        for (int j=0;j<k;j++){
            result[j] = temp[j];
        }
        return result;
    }
}
