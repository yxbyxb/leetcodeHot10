package com.example.leetcodehot100;

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
        BuildTree_105 buildTree_105 = new BuildTree_105();
        TreeNode treeNode = buildTree_105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        LevelOrder_102 levelOrder_102 = new LevelOrder_102();
        List<List<Integer>> lists = levelOrder_102.levelOrder(treeNode);
        System.out.println(lists);
//        测试git
    }

}
