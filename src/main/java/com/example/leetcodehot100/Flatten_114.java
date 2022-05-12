package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

public class Flatten_114 {
    public void flatten(TreeNode root) {
        myFlatten(root);
    }

    private void myFlatten(TreeNode root){
        if (root==null) return;
        if (root.left==null){
            myFlatten(root.right);
        }
        else {
            TreeNode lastOfLeft = getLastOfLeft(root.left);
            lastOfLeft.right = root.right;
            root.right = root.left;
            root.left = null;
            myFlatten(root.right);
        }
    }

    private TreeNode getLastOfLeft(TreeNode treeNode){
        if (treeNode.right!=null){
            return getLastOfLeft(treeNode.right);
        }else if (treeNode.left!=null){
            return getLastOfLeft(treeNode.left);
        }else {
            return treeNode;
        }
    }
}
