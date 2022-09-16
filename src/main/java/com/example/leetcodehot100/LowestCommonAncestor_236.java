package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor_236 {
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return this.result;
    }

    /**
     * return new boolean[2]; boolean[0]:canReachP boolean[1]:canReachQ
     */
    private boolean[] dfs(TreeNode root, TreeNode p, TreeNode q) {
        boolean[] result = new boolean[2];
        if (root == null) {
            return result;
        }
        if (root == p) {
            result[0] = true;
        }
        if (root == q) {
            result[1] = true;
        }
        if (result[0]&&result[1]){
        } else {
            boolean[] dfs = dfs(root.left, p, q);
            if (dfs[0]) {
                result[0] = dfs[0];
            }
            if (dfs[1]) {
                result[1] = dfs[1];
            }
            if (result[0]&&result[1]){
            } else {
                boolean[] dfs1 = dfs(root.right, p, q);
                if (dfs1[0]) {
                    result[0] = dfs1[0];
                }
                if (dfs1[1]) {
                    result[1] = dfs1[1];
                }
            }
        }
        if (result[0]&&result[1] && this.result==null) {
            this.result = root;
        }
        return result;
    }

//    存储父节点 太过dinner
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Deque<TreeNode> pParent = new ArrayDeque<>();
//        Deque<TreeNode> qParent = new ArrayDeque<>();
//        dfs(pParent, p, root);
//        dfs(qParent, q, root);
//        Set<TreeNode> appeared = new HashSet<>();
//        if (pParent.size() > qParent.size()) {
//            this.addAll(appeared, qParent);
//            this.addAll(appeared, pParent);
//        } else {
//            this.addAll(appeared, pParent);
//            this.addAll(appeared, qParent);
//        }
//        return this.result;
//    }
//
//    private void addAll(Set<TreeNode> appeared, Deque<TreeNode> parents) {
//        while (!parents.isEmpty()) {
//            TreeNode pop = parents.pop();
//            if (!appeared.add(pop)) {
//                this.result = pop;
//                return;
//            }
//        }
//    }
//
//    /**
//     * return deeper
//     * */
//    private boolean dfs(Deque<TreeNode> appeared, TreeNode target, TreeNode current) {
//        if (current == null) {
//            return true;
//        }
//        boolean deeper;
//        appeared.push(current);
//        if (current == target) {
//            deeper = false;
//        } else {
//            deeper = true;
//        }
//        if (deeper) {
//            boolean dfs = dfs(appeared, target, current.left);
//            if (dfs) {
//                boolean dfs1 = dfs(appeared, target, current.right);
//                if (dfs1) {
//
//                }else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//        appeared.pop();
//        return true;
//    }
}
