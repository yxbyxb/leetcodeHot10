package com.example.leetcodehot100;

import java.util.List;

public class WordBreak_139 {

    /**
     *
     * 小比动态规划就这？我直接拿下啊
     *
     * dp[i] 表示0~i个字母能不能拼成
     * dp[i] = hasTrue(dp[i-n]) n为wordDict里每一个单词的长度 有一个为true则dp[i]为true 否则为false
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
//        dp[i] 表示0~i-1 即前i个
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1;i<dp.length;i++){
            boolean temp = false;
            for (String word : wordDict){
                int begin = i-word.length();
                if (begin>=0&&dp[begin]&&word.equals(s.substring(begin,i))){
                    temp = true;
                    break;
                }
            }
            dp[i] = temp;
        }
        return dp[dp.length-1];
    }
}
