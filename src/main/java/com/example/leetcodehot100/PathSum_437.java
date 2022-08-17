package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum_437 {

    /**
     *  map.get(node) 表示根节点到node的和
     *  sum(a->b) = m.b-m.a+b
     *  k = m.b-m.a+a
     *  k = m.b - m.a.lastSum
     *  m.b = k + m.a.lastSum
     */
    private int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        this.dfs(map,root,0,targetSum);
        return this.result;
    }

    private void dfs(Map<Long,Integer> map, TreeNode root, long lastSum, int targetSum){
        if (root==null) {
            return;
        }
        long currentSum = lastSum+root.val;
        if (map.containsKey(currentSum-targetSum)){
            this.result += map.get(currentSum-targetSum) ;
        }
        map.put(currentSum,map.getOrDefault(currentSum,0)+1);
        dfs(map,root.left,currentSum,targetSum);
        dfs(map,root.right,currentSum,targetSum);
        int before = map.get(currentSum)-1;
        if (before==0){
            map.remove(currentSum);
        }else {
            map.put(currentSum,before);
        }
    }


//    以下为石山代码
//    private int result = 0;
//    Set<TreeNode> set = new HashSet<>();
//    public int pathSum(TreeNode root, int targetSum) {
//        set.add(root);
//        myPathSum(root,targetSum,0);
//        return this.result;
//    }
//
//    private void myPathSum(TreeNode root, int targetSum, long sum) {
//        if (root==null){
//            return;
//        }
//        sum+=root.val;
//        if (targetSum==sum){
//            this.result+=1;
//        }
//
//        myPathSum(root.left,targetSum,sum);
//        myPathSum(root.right,targetSum,sum);
//        if (set.add(root.left)){
//            myPathSum(root.left,targetSum,0);
//        }
//        if (set.add(root.right)){
//            myPathSum(root.right,targetSum,0);
//        }
//    }
}
