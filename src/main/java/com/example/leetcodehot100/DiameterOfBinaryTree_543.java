package com.example.leetcodehot100;

public class DiameterOfBinaryTree_543 {

//          Definition for a binary tree node.
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        setMaxDepth(root);
        int result = maxDiameter(root);
        return result-1;
    }

    public int maxDiameter(TreeNode root) {
        if (root==null){
            return 0;
        }
        int result = 0;
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left!=null){
            leftDepth = root.left.val;
        }
        if (root.right!=null){
            rightDepth = root.right.val;
        }
        result = Math.max(leftDepth+rightDepth+1,
                Math.max(maxDiameter(root.left),maxDiameter(root.right)));
        return result;
    }

    public int setMaxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        root.val = Math.max(setMaxDepth(root.left),setMaxDepth(root.right))+1;
        return root.val;
    }
}
