package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {

//    有细节上的优化空间

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int curr = 0;
        int[] pBlock = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pBlock[p.charAt(i) - 'a'] += 1;
        }
        int[] block = new int[26];
        for (int i = 0; i < p.length(); i++) {
            block[s.charAt(i) - 'a'] += 1;
        }
        int start = 0;
        int end = p.length() - 1;
        if (Arrays.equals(block, pBlock)) {
            result.add(start);
            start++;
            end++;
            curr++;
        }
        for (; end < s.length(); start++, end++) {
            if (curr != 0 && result.get(curr - 1) == start - 1 && s.charAt(end) == s.charAt(start - 1)) {
                result.add(start);
                curr++;
            } else {
                if (start != 0) {
                    int lastIndex = s.charAt(start - 1) - 'a';
                    if (block[lastIndex] > 0) {
                        block[lastIndex]--;
                    }
                    block[s.charAt(end) - 'a']++;
                    if (Arrays.equals(block, pBlock)) {
                        result.add(start);
                        curr++;
                    } else {
                    }
                }
            }
        }
        return result;
    }

    boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
