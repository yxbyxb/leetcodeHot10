package com.example.leetcodeDaily;

public class CheckPalindromeFormation_1616 {
//    6种情况符合提议
//    1.a yes 2.b yes 3.ai,bj -> ai,aj 4.ai,bj -> bi,bj 5.bi,aj -> bi,bj 6.bi,aj -> ai,aj

    public boolean checkPalindromeFormation(String a, String b) {
//        a的双指针
        int ai = 0;
        int aj = b.length() - 1;
//        b的双指针
        int bi = 0;
        int bj = a.length() - 1;
        boolean aYes;
        boolean bYes;
        aYes = isaYes(b, a, ai, aj);
        if (aYes) {
            return true;
        }
        bYes = isaYes(a, b, bi, bj);
        return bYes;
    }

//    判断
    private boolean isaYes(String a, String b, int ai, int aj) {
        boolean isChanged = false;
        for (; ai < aj; ) {
            if (!isChanged) {
                if (a.charAt(ai) == b.charAt(aj)) {
                    ai++;
                    aj--;
                } else {
                    isChanged = true;
                    break;
                }
            }
        }
        if (!isChanged) {
            return true;
        }
        boolean change = change(a, isChanged, ai, aj);
        if (change) {
            return true;
        }
        change = change(b, isChanged, ai, aj);
        return change;
    }

//    更换之后
    private boolean change(String a, boolean isChanged, int ai, int aj) {
        boolean aYes = true;
        while (ai < aj) {
            if (isChanged) {
                if (a.charAt(ai) == a.charAt(aj)) {
                    ai++;
                    aj--;
                } else {
                    aYes = false;
                    break;
                }
            }
        }
        return aYes;
    }
}
