package com.example.leetcodehot100;

import java.util.ArrayList;
import java.util.List;

//回溯 深度遍历 只要当满足条件就往下深入 不满足条件返回后继续找同一层的下一个
//        执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//        内存消耗：39.9 MB, 在所有 Java 提交中击败了53.92%的用户
public class LetterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return new ArrayList<>();
        }
        char[][] phoneNumbers = new char[][]{
                {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> result = new ArrayList<>();
        flashBack(new StringBuffer(),result,0,phoneNumbers,digits);
        return result;
    }

    private void flashBack(StringBuffer tempString,List<String> result,int indexOfDigits,char[][] phoneNumbers,String digits){
        if (indexOfDigits==digits.length()){
            result.add(tempString.toString());
        }else{
            int thisNum = digits.charAt(indexOfDigits)-'0';
            for (int i=0;i<phoneNumbers[thisNum-2].length;i++){
                tempString.append(phoneNumbers[thisNum-2][i]);
                flashBack(tempString,result,indexOfDigits+1,phoneNumbers,digits);
                tempString.deleteCharAt(tempString.length()-1);
            }
        }
    }
}
