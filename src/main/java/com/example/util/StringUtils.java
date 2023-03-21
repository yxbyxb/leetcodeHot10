package com.example.util;

public class StringUtils {
    public static String replaceMidBracketWithBigBracket(String s){
        String s1 = s.replaceAll("\\[", "{");
        return s1.replaceAll("]", "}");
    }
}
