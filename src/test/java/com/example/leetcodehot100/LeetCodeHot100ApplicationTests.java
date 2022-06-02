package com.example.leetcodehot100;

import com.example.pojo.ListNode;
import com.example.pojo.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    public void doSomeTest() {
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
                new char[]{'1', '1', '1', '1','1', '1', '1', '1'},
                new char[]{'1', '1', '1', '1','1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1','1', '1', '1', '0'},
                new char[]{'1', '1', '1', '1','1', '0', '0', '0'},
                new char[]{'0', '1', '1', '1','1', '0', '0', '0'},
        };
        int i = maximalSquare_221.maximalSquare(chars6);
        System.out.println(i);
    }

}
