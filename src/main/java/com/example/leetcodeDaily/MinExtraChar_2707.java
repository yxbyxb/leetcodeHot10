package com.example.leetcodeDaily;

import java.util.*;

public class MinExtraChar_2707 {
    int result = 0;
    List<String> words = new ArrayList<>();

    int maxWordLength = 0;

    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
//        dp[0] = dict.contains(s.substring(0,1)) ? 0 : 1;
        for (int i = 1; i <= s.length(); i++) {
            int minDpI = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j ++) {
                if (dict.contains(s.substring(j,i))) {
                    int currentDpI = dp[j];
                    if (currentDpI < minDpI) {
                        minDpI = currentDpI;
                    }
                }
            }
            minDpI = Math.min(minDpI, dp[i - 1] + 1);
            dp[i] = minDpI;
        }
        return dp[s.length()];

//        Set<String> dict = new HashSet<>();
//        for (String s1 : dictionary) {
//            dict.add(s1);
//            if (s1.length() > maxWordLength) {
//                maxWordLength = s1.length();
//            }
//        }
//        result = Integer.MAX_VALUE - maxWordLength;
//        findDict(0, 0, 0, dict, s);
//        return result;
    }

    private void findDict(int start, int end, int unUsed, Set<String> dict, String s) {
        if (end >= s.length()) {
            if (unUsed < result) {
                result = unUsed;
                System.out.println("-----------start");
                for (String word : words) {
                    System.out.println(word);
                }
                System.out.println("-----------end");
            }
            return;
        }
//        剪枝不会剪寄咯
        if (unUsed > result + maxWordLength / 2) {
            return;
        }
        unUsed += 1;
        if (dict.contains(s.substring(start, end + 1))) {
            findDict(start, end + 1, unUsed, dict, s);
            words.add(s.substring(start, end + 1));
            findDict(end + 1, end + 1, unUsed - (end - start + 1), dict, s);
            words.remove(words.size() - 1);
        } else {
            findDict(start, end + 1, unUsed, dict, s);
            findDict(end + 1, end + 1, unUsed, dict, s);
        }
    }


}
