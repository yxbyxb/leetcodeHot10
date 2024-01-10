package com.example.leetcodeDaily;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinLength_2696 {
//    使用StringBuilder
    public int minLength(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        while (true) {
            int ab = stringBuilder.indexOf("AB");
            int cd = stringBuilder.indexOf("CD");
            if (!(ab != -1 || cd != -1)) break;
            int start = ab == -1 ? cd : ab;
            stringBuilder.delete(start, start + 2);
        }
        return stringBuilder.length();
    }

//    使用栈
    public int minLengthAnother(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                Character peek = stack.peek();
                if (peek != null && peek == 'A') {
                    stack.pop();
                    continue;
                }
            }
            if (s.charAt(i) == 'D') {
                Character peek = stack.peek();
                if (peek != null && peek == 'C') {
                    stack.pop();
                    continue;
                }
            }

            stack.push(s.charAt(i));
        }
        return stack.size();
    }
}
