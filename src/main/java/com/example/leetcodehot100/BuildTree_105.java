package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int thisIndex = map.get(preorder[0]);
        root.left = new TreeNode();
        int l = createTree(preorder,inorder,1,0,thisIndex-1,root.left);
        if (l==-1){
            root.left=null;
        }
        root.right = new TreeNode();
        int r = createTree(preorder,inorder,1+thisIndex,thisIndex+1,inorder.length-1,root.right);
        if (r==-1){
            root.right = null;
        }
        return root;
    }

    private int createTree(int[] preorder, int[] inorder,int indexOfPre,int inorderLeft,int inorderRight,TreeNode temp){
        if (inorderLeft>inorderRight){
            return -1;
        }
        temp.val = preorder[indexOfPre];
        int thisIndex = map.get(preorder[indexOfPre]);
        temp.left = new TreeNode();
        int l = createTree(preorder,inorder,indexOfPre+1,inorderLeft,thisIndex-1,temp.left);
        if (l==-1){
            temp.left=null;
        }
        temp.right = new TreeNode();
        int r = createTree(preorder,inorder,indexOfPre+(thisIndex-inorderLeft)+1,thisIndex+1,inorderRight,temp.right);
        if (r==-1){
            temp.right = null;
        }
        return 1;
    }
}
