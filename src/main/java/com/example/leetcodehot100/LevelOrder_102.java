package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if (poll.left!=null){
                    nextLevel.add(poll.left);
                }
                if (poll.right!=null){
                    nextLevel.add(poll.right);
                }
            }
            queue = nextLevel;
            result.add(temp);
        }

        return result;
    }
}
