package com.example.leetcodeDaily;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs_447 {
    //    把任意一个点作为中间的点，分别求出其他的所有的点到这个点的距离，存放在map里，答案的数量是P(n,2),从n里面选2个点排列
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int[] point : points) {
            Map<Integer, Integer> map = new HashMap<>();
//            只有自己为0，所以不用考虑跳过
            for (int[] point1 : points) {
                int length = (point1[0] - point[0]) * (point1[0] - point[0]) + (point1[1] - point[1]) * (point1[1] - point[1]);
                map.put(length, map.getOrDefault(length, 0) + 1);
            }
            for (Integer value : map.values()) {
                result += value * (value - 1);
            }
        }
        return result;
    }
}
