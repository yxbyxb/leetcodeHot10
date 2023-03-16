package com.example.leetcodeDaily;

import java.util.ArrayList;
import java.util.List;

public class MaximalNetworkRank_1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int result = 0;
        int[] count = new int[n + 1];
        boolean[][] isLinked = new boolean[n][n];
        List<Integer> maxIndexList = new ArrayList<>(n);
        List<Integer> secondMaxIndexList = new ArrayList<>(n);
        for (int i = 0; i < roads.length; i++) {
            isLinked[roads[i][0]][roads[i][1]] = true;
            isLinked[roads[i][1]][roads[i][0]] = true;
            count[roads[i][0]]++;
            count[roads[i][1]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > count[getIndex(maxIndexList, n)]) {
                secondMaxIndexList = maxIndexList;
                maxIndexList = new ArrayList<>(n);
                maxIndexList.add(i);
            } else if (count[i] == count[getIndex(maxIndexList, n)]) {
                maxIndexList.add(i);
            } else if (count[i] > count[getIndex(secondMaxIndexList, n)]) {
                secondMaxIndexList.clear();
                secondMaxIndexList.add(i);
            } else if (count[i] == count[getIndex(secondMaxIndexList, n)]) {
                secondMaxIndexList.add(i);
            }
        }
        if (maxIndexList.isEmpty()) {
            return 0;
        }
        if (maxIndexList.size() >= 2) {
            result = count[maxIndexList.get(0)] * 2;
            for (int i = 0; i < maxIndexList.size() - 1; i++) {
                for (int j = i + 1; j < maxIndexList.size(); j++) {
                    if (!isLinked[maxIndexList.get(i)][maxIndexList.get(j)]) {
                        return result;
                    }
                }
            }
            return --result;
        }
        if (maxIndexList.size() == 1 && !secondMaxIndexList.isEmpty()) {
            result = count[maxIndexList.get(0)] + count[secondMaxIndexList.get(0)];
            for (int i = 0; i < secondMaxIndexList.size(); i++) {
                if (!isLinked[maxIndexList.get(0)][secondMaxIndexList.get(i)]) {
                    return result;
                }
            }
            return --result;
        }
        return result;
    }

    private int getIndex(List<Integer> indexList, int n) {
        if (indexList == null || indexList.isEmpty()) {
            return n;
        }
        return indexList.get(0);
    }
}
