package com.example.leetcodeDaily;

import com.example.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetAllElements_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> getRoot1 = new ArrayList<>();
        getOneTree(root1,getRoot1);
        List<Integer> getRoot2 = new ArrayList<>();
        getOneTree(root2,getRoot2);
        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        for (;i<getRoot1.size()&&j<getRoot2.size();){
            if (getRoot1.get(i)<getRoot2.get(j)){
                result.add(getRoot1.get(i));
                i++;
            }else {
                result.add(getRoot2.get(j));
                j++;
            }
        }
        if (i!=getRoot1.size()){
            for (;i<getRoot1.size();i++){
                result.add(getRoot1.get(i));
            }
        }else{
            for (;j<getRoot2.size();j++){
                result.add(getRoot2.get(j));
            }
        }

        return result;
    }

    private void getOneTree(TreeNode root,List<Integer> result){
        if (root==null){
            return;
        }else{
            getOneTree(root.left,result);
            result.add(root.val);
            getOneTree(root.right,result);
        }
    }
}
