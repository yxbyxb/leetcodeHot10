package com.example.leetcodehot100;

import com.example.pojo.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void doSomeTest() {
        CombinationSum_39 combinationSum_39 = new CombinationSum_39();
        List<List<Integer>> lists = combinationSum_39.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list:lists){
            for (Integer temp:list){
                System.out.println(temp);
            }
        }
    }

}
