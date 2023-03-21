package com.example.leetcodehot100;

import com.example.leetcodeDaily.AnswerQueries_2389;
import com.example.leetcodeDaily.CountSubarrays_2488;
import com.example.util.StringUtils;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    public void doSomeTest() {
        String s = StringUtils.replaceMidBracketWithBigBracket("[[0,1],[0,3],[1,2],[1,3]]");
        System.out.println(s);
    }

    @Test
    public void CountSubarrays_2488Test() {
        CountSubarrays_2488 countSubarrays2488 = new CountSubarrays_2488();
        int[] nums = {5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14};
        int i = countSubarrays2488.countSubarrays(nums, 6);
        System.out.println(i);

    }

    @Test
    public void AnswerQueries_2389Test() {
        int[] nums = {4,5,2,1};
        int[] queries  = {3,10,21};
        AnswerQueries_2389 answerQueries2389 = new AnswerQueries_2389();
        int[] ints = answerQueries2389.answerQueries(nums, queries);
        System.out.println(ints);
    }

    @Test
    public void maximalSquare_221_Test() {
        MaximalSquare_221 maximalSquare_221 = new MaximalSquare_221();
        char[][] chars1 = new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'},
        };
        char[][] chars2 = new char[][]{
                new char[]{'1', '0'},
                new char[]{'0', '1'},
        };
        char[][] chars3 = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'0', '0', '1', '1', '1'},
        };
        char[][] chars4 = new char[][]{
                new char[]{'1', '1'},
                new char[]{'1', '1'},
        };
        char[][] chars5 = new char[][]{
                new char[]{'0', '0', '0', '1'},
                new char[]{'1', '1', '0', '1'},
                new char[]{'1', '1', '1', '1'},
                new char[]{'0', '1', '1', '1'},
                new char[]{'0', '1', '1', '1'},
        };
        char[][] chars6 = new char[][]{
                new char[]{'1', '1', '1', '1', '1', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1', '1', '0', '0', '0'},
                new char[]{'0', '1', '1', '1', '1', '0', '0', '0'},
        };
        int i = maximalSquare_221.maximalSquare(chars6);
        System.out.println(i);
    }

}
