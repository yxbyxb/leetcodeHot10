package com.example.leetcodehot100;

public class IsMatch_10 {
    public boolean isMatch(String s, String p) {
//        return myMatch(s.toCharArray(),p.toCharArray(),0,0);
//        j如果遇到*就-2
//        dp[i][j] i代表s j代表p dp[i][j] = (dp[i-1][j]&&j-1=*&&j-2==i)||(dp[i-1][j-1]&&i=j)
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i=0;i<dp.length;i++){
            for (int j=1;j<dp[0].length;){
                if (nextIsPlus(charsP,j-1)){
                    if (dp[i][j-1]){
                        dp[i][j] = true;
                        dp[i][j+1] = true;
                        j+=2;
                    }else {
                        break;
                    }
                }else {
                    if (dp[i-1][j-1]&&(charsP[j-1]=='.'||charsS[i-1]==charsP[j-1])){
                        dp[i][j] = true;
                    }
                    j++;
                    break;
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    //    芜 我的回溯又回来啦
    private boolean myMatch(char[] s, char[] p, int indexS, int indexP) {
        if (indexS >= s.length && indexP >= p.length) {
            return true;
        }
        if (indexP >= p.length && indexS <= s.length) {
            return false;
        }
        if (indexS >= s.length) {
            while (indexP < p.length && nextIsPlus(p, indexP)) {
                indexP += 2;
            }
            if (indexP >= p.length) {
                return true;
            } else {
                return false;
            }
        }
        if (nextIsPlus(p, indexP)) {
            if (p[indexP] == '.') {
                boolean val1 = myMatch(s, p, indexS, indexP + 2);
                if (val1) {
                    return true;
                }
                boolean val2 = myMatch(s, p, indexS + 1, indexP);
                if (val2) {
                    return true;
                }
            } else {
                if (s[indexS] == p[indexP]) {
                    boolean val1 = myMatch(s, p, indexS, indexP + 2);
                    if (val1) {
                        return true;
                    }
                    boolean val2 = myMatch(s, p, indexS + 1, indexP);
                    if (val2) {
                        return true;
                    }
                } else {
                    boolean val1 = myMatch(s, p, indexS, indexP + 2);
                    if (val1) {
                        return true;
                    }
                }
            }
        } else {
            if (p[indexP] == '.') {
                boolean val1 = myMatch(s, p, indexS + 1, indexP + 1);
                if (val1) {
                    return true;
                }
            } else {
                if (s[indexS] == p[indexP]) {
                    boolean val1 = myMatch(s, p, indexS + 1, indexP + 1);
                    if (val1) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private boolean nextIsPlus(char[] pattern, int index) {
        if (index + 1 < pattern.length && pattern[index + 1] == '*') {
            return true;
        }
        return false;
    }
}
