package com.example.leetcodehot100;

import com.example.pojo.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

//@SpringBootTest
class LeetCodeHot100ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void doSomeTest() {
        NextPermutation_31 nextPermutation_31 = new NextPermutation_31();
        int[] nums = new int[]{3,2,1};
        nextPermutation_31.nextPermutation(nums);
        System.out.println("1");
    }

}
