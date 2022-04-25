package com.example.leetcodehot100;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int temp = 0;
        Set<Character> set = new HashSet<>();
        for (int i=0,j=0;j<s.length();){
            boolean flag = set.add(s.charAt(j));
            if (flag){
                temp++;
                result = Math.max(result,temp);
                j++;
            }else{
                set.remove(s.charAt(i));
                temp--;
                i++;
            }
        }
        return result;
    }
}
