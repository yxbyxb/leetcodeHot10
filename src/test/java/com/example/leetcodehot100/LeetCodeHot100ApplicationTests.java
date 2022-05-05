package com.example.leetcodehot100;

import com.example.leetcodeDaily.NumSubarrayProductLessThanK_713;
import com.example.leetcodeDaily.ReorderLogFiles_937;
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
        Subsets_78 subsets_78 = new Subsets_78();
        List<List<Integer>> subsets = subsets_78.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

}
