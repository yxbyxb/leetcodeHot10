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
        LRUCache_146 lruCache_146 = new LRUCache_146(2);
        lruCache_146.put(2,1);
        lruCache_146.put(1,1);
        lruCache_146.put(2,3);
        lruCache_146.put(4,1);
        System.out.println(lruCache_146.get(1));
        System.out.println(lruCache_146.get(2));
    }

}
