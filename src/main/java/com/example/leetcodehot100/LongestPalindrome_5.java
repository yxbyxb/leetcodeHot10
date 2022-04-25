package com.example.leetcodehot100;

public class LongestPalindrome_5 {

//    暴力 超时
//    public static String longestPalindrome(String s) {
//        if (s.length()==1){
//            return s;
//        }
//        String result = "";
//        for (int i=0;i<=s.length()-1;i++){
//            for (int j=i+1;j<=s.length();j++){
//                String temp = s.substring(i,j);
//                if (isPalindrome(temp)){
//                    if (temp.length()>result.length()){
//                        result = temp;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    动态规划 dp表示下标为i开始
//    长度为l的数组 是否为回文
//    dp[i][l] = (dp[i+1][l-2]&&s[i]==s[i+l-1])
//
//    private static boolean isPalindrome(String s){
//        boolean result = true;
//        for (int i=0,j=s.length()-1;j>i;i++,j--){
//            if (s.charAt(i)!=s.charAt(j)){
//                result = false;
//                break;
//            }
//        }
//        return result;
//    }

//    动态规划
//    执行用时：220 ms, 在所有 Java 提交中击败了24.30%的用户
//    内存消耗：46.7 MB, 在所有 Java 提交中击败了6.07%的用户
    public static String longestPalindrome(String s) {
        if (s.length()==1){
            return s;
        }
        String result = s.charAt(0)+"";
        boolean[][] dp = new boolean[s.length()][s.length()+1];
        for (int i = 0;i<s.length();i++){
            dp[i][0] = true;
            dp[i][1] = true;
        }

        for (int l=2;l<s.length()+2;l++){
            for (int i = 0;i<s.length()-l+1;i++){
                dp[i][l] = (dp[i+1][l-2]&&s.charAt(i)==s.charAt(i+l-1));
                if (dp[i][l]&&l>result.length()){
                    result = s.substring(i,i+l);
                }
            }
        }
        return result;
    }
}
