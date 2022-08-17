package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddOneRow_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode temp = new TreeNode(val, root, null);
            return temp;
        }
        dfs(root, val, depth, 1);
        return root;
    }

    private void dfs(TreeNode root, int val, int depth, int currentDepth) {
        if (root==null){
            return;
        }
        if (currentDepth>=depth){
            return;
        }
        if (currentDepth == depth - 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return;
        }
        dfs(root.left,val,depth,currentDepth+1);
        dfs(root.right,val,depth,currentDepth+1);
    }

//    public TreeNode addOneRow(TreeNode root, int val, int depth) {
//        TreeNode result = root;
//        if (depth == 1) {
//            TreeNode temp = new TreeNode(val, root, null);
//            return temp;
//        }
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        stack.push(root);
//        levelOrder(stack, val, depth, 1);
//        return root;
//    }
//
//    private void levelOrder(Deque<TreeNode> currentLevel, int val, int depth, int currentDepth) {
//        if (currentDepth == depth - 1) {
//            while (!currentLevel.isEmpty()) {
//                TreeNode pop = currentLevel.pop();
//                TreeNode temp = pop.left;
//                pop.left = new TreeNode(val, temp, null);
//                temp = pop.right;
//                pop.right = new TreeNode(val, null, temp);
//            }
//        } else {
//            Deque<TreeNode> tempStack = new ArrayDeque<>();
//            while (!currentLevel.isEmpty()) {
//                TreeNode pop = currentLevel.pop();
//                if (pop.left != null) {
//                    tempStack.push(pop.left);
//                }
//                if (pop.right != null) {
//                    tempStack.push(pop.right);
//                }
//            }
//            levelOrder(tempStack, val, depth, currentDepth + 1);
//        }
//    }

    //    bfs无递归版本
//    public TreeNode addOneRow(TreeNode root, int val, int depth) {
//        TreeNode result = root;
//        if (depth == 1) {
//            TreeNode temp = new TreeNode(val, root, null);
//            return temp;
//        }
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        stack.push(root);
//        for (int i = 0; i < depth - 2; i++) {
//            Deque<TreeNode> tempStack = new ArrayDeque<>();
//            while (!stack.isEmpty()) {
//                TreeNode pop = stack.pop();
//                if (pop.left != null) {
//                    tempStack.push(pop.left);
//                }
//                if (pop.right != null) {
//                    tempStack.push(pop.right);
//                }
//            }
//            stack = tempStack;
//        }
//        while (!stack.isEmpty()) {
//            TreeNode pop = stack.pop();
//            TreeNode temp = pop.left;
//            pop.left = new TreeNode(val, temp, null);
//            temp = pop.right;
//            pop.right = new TreeNode(val, null, temp);
//        }
//        return result;
//    }
}
