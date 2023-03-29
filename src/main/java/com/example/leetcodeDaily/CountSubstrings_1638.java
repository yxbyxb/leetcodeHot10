package com.example.leetcodeDaily;

public class CountSubstrings_1638 {
//    不会动态规划 草了
    public int countSubstrings(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int sameCount = 0;
            int resulCount = 0;
            int difference = 0;
            int k = 0;
            for (; i + k < s.length() && k < t.length(); k++) {
                difference += s.charAt(i + k) == t.charAt(k) ? 0 : 1;
                if (difference == 0) {
                    sameCount++;
                }
                if (difference == 1) {
                    result++;
                    resulCount++;
                }
                if (difference > 1) {
                    break;
                }
            }
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j - 1)) {
                    result += --resulCount;
                    sameCount--;
                    continue;
                }
                sameCount = --resulCount;
                resulCount = 0;
                difference = 0;
                for (; i + k < s.length() && j + k < t.length(); k++) {
                    difference += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    if (difference == 0) {
                        sameCount++;
                    }
                    if (difference == 1) {
                        result++;
                        resulCount++;
                    }
                    if (difference > 1) {
                        break;
                    }
                }
            }
        }
        return result;
    }


//    怎么暴力都不会的吗，想什么呢
//    public int countSubstrings(String s, String t) {
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < t.length(); j++) {
//                int difference = 0;
//                for (int k = 0; i + k < s.length() && j + k < t.length(); k++) {
//                    difference += s.charAt(i+k) == t.charAt(j+k) ? 0 : 1;
//                    if (difference == 1) {
//                        result ++;
//                    }
//                    if (difference > 1) {
//                        break;
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
