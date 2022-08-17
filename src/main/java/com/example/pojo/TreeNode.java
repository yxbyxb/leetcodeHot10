package com.example.pojo;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public void levelOrder () {
        TreeNode root = this;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        int index = 0;
        while (!stack.isEmpty()){
            Deque<TreeNode> tempStack = new ArrayDeque<>();
            System.out.print("第"+index+"层：");
            while (!stack.isEmpty()) {
                TreeNode pop = stack.removeFirst();
                System.out.print(pop.val);
                if (pop.left!=null){
                    tempStack.addLast(pop.left);
                }
                if (pop.right!=null){
                    tempStack.addLast(pop.right);
                }
            }
            index++;
            System.out.println(" ");
            stack = tempStack;
        }
    }
}
