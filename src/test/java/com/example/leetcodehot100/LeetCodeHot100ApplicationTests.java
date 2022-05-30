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
        Rob_198 rob_198 = new Rob_198();
        int rob = rob_198.rob(new int[]{1,2,3,1});
        System.out.println(rob);
    }

}
