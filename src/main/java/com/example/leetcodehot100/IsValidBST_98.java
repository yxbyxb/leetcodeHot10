package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

public class IsValidBST_98 {
    public boolean isValidBST(TreeNode root) {
        return myIsValidBST(root,new int[1000],new int[1000],0,0);
    }

    private boolean myIsValidBST(TreeNode root,int[] needSmaller,int[] needBigger,int indexOfSmaller,int indexOfBigger){
        boolean resulLeft = false;
        boolean resultRight = false;
        if(root.left!=null){
            needSmaller[indexOfSmaller++] = root.val;
            if (allSmaller(needSmaller,root.left.val,indexOfSmaller)&&allBigger(needBigger,root.left.val,indexOfBigger)){
                resulLeft = myIsValidBST(root.left,needSmaller,needBigger,indexOfSmaller,indexOfBigger);
                if (!resulLeft){
                    return false;
                }
                indexOfSmaller--;
            }else {
                return false;
            }
        }else {
            resulLeft = true;
        }
        if (root.right!=null){
            needBigger[indexOfBigger++] = root.val;
            if (allBigger(needBigger,root.right.val,indexOfBigger)&&allSmaller(needSmaller,root.right.val,indexOfSmaller)){
                resultRight =  myIsValidBST(root.right,needSmaller,needBigger,indexOfSmaller,indexOfBigger);
                indexOfBigger--;
            }else {
                return false;
            }
        }else {
            resultRight = true;
        }
        return resulLeft&&resultRight;
    }

    private boolean allSmaller(int[] needCompare, int val, int lastIndex){
        for (int i=0;i<lastIndex;i++){
            if (val>=needCompare[i]){
                return false;
            }
        }
        return true;
    }

    private boolean allBigger(int[] needCompare, int val, int lastIndex){
        for (int i=0;i<lastIndex;i++){
            if (val<=needCompare[i]){
                return false;
            }
        }
        return true;
    }
}
