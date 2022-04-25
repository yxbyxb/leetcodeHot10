package com.example.leetcodeDaily;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//    执行用时：7 ms, 在所有 Java 提交中击败了16.26%的用户
//    内存消耗：41.2 MB, 在所有 Java 提交中击败了64.15%的用户
public class ShortestToChar_821 {
    public static int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        List<Integer> indexOfC = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            if (c==s.charAt(i)){
                indexOfC.add(i);
            }
        }
        int lastJ=0;
        for (int i=0;i<s.length();i++){
            if (i<indexOfC.get(0)){
                result[i] = indexOfC.get(0)-i;
                continue;
            }
            if (i>indexOfC.get(indexOfC.size()-1)){
                result[i] = i-indexOfC.get(indexOfC.size()-1);
                continue;
            }
            for (int j=lastJ;j<indexOfC.size()-1;j++){
                if (i>=indexOfC.get(j)&&i<indexOfC.get(j+1)){
                    result[i] = Math.min(i-indexOfC.get(j),indexOfC.get(j+1)-i);
                    lastJ = j;
                }
            }
        }
        return result;
    }
}
