package com.example.leetcodehot100;

import java.util.AbstractMap;
import java.util.Map;

public class DecodeString_394 {
    public String decodeString(String s) {
        return getString(s,0).getKey();
    }

    private Map.Entry<String ,Integer> getString(String s, int index){
        if (index>=s.length()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(index<s.length()){
            if (isLetter(s.charAt(index))){
                stringBuilder.append(s.charAt(index));
                index++;
            }else if (isNum(s.charAt(index))){
                int times = 0;
                while (isNum(s.charAt(index))){
                    times = times*10+(s.charAt(index)-'0');
                    index++;
                }
                index++;
                Map.Entry<String, Integer> string = getString(s, index);
                for (int i=0;i<times;i++){
                    stringBuilder.append(string.getKey());
                }
                index = string.getValue();
            }else {
                index++;
                break;
            }
        }
        return new AbstractMap.SimpleEntry<>(stringBuilder.toString(),index);
    }
    private boolean isNum(char c){
        int chr=c;
        if(chr<48 || chr>57)
            return false;
        else{
            return true;
        }
    }
    private boolean isLetter(char c){
        if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))){
            return true;
        }else {
            return false;
        }
    }
}
