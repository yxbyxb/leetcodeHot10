package com.example.leetcodehot100;

import com.example.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Rob_337 {
    //    f打劫当前节点 g不打劫当前节点
    public int rob(TreeNode root) {
        TreeNode f = copyTree(root);
        TreeNode g = copyTree(root);
        getF(root, f, g);
        getG(root, f, g);
        return f.val > g.val ? f.val : g.val;
    }

    private int getF(TreeNode root, TreeNode f, TreeNode g) {
        int val = root.val;
        if (root.left != null) {
            if (g.left.val != root.left.val) {
                val += g.left.val;
            } else {
                val += getG(root.left, f.left, g.left);
            }
        }
        if (root.right != null) {
            if (g.right.val != root.right.val) {
                val += g.right.val;
            } else {
                val += getG(root.right, f.right, g.right);
            }
        }
        if (root.left == null && root.right == null) {
            return val;
        }
        f.val = val;
        return val;
    }

    private int getG(TreeNode root, TreeNode f, TreeNode g) {
        int val = 0;
        if (root.left != null) {
            int fVal = 0;
            if (f.left.val != root.left.val) {
                fVal = f.left.val;
            } else {
                fVal = getF(root.left, f.left, g.left);
            }
            int gVal = 0;
            if (g.left.val != root.left.val) {
                gVal = g.left.val;
            } else {
                gVal = getG(root.left, f.left, g.left);
            }
            val += fVal > gVal ? fVal : gVal;
        }
        if (root.right != null) {
            int fVal = 0;
            if (f.right.val != root.right.val) {
                fVal = f.right.val;
            } else {
                fVal = getF(root.right, f.right, g.right);
            }
            int gVal = 0;
            if (g.right.val != root.right.val) {
                gVal = g.right.val;
            } else {
                gVal = getG(root.right, f.right, g.right);
            }
            val += fVal > gVal ? fVal : gVal;
        }
        if (root.left == null && root.right == null) {
            g.val = 0;
            return 0;
        }
        g.val = val;
        return val;
    }

    private TreeNode copyTree(TreeNode root) {
        TreeNode result = new TreeNode();
        if (root != null) {
            result.val = root.val;
        }
        if (root.left != null) {
            result.left = copyTree(root.left);
        }
        if (root.right != null) {
            result.right = copyTree(root.right);
        }
        return result;
    }


    //    简洁版
//    i=0 f i=1 g
    private int myRob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int[] result = new int[2];
        result[0] = root.val + l[1] + r[1];
        int ml = l[0] > l[1] ? l[0] : l[1];
        int mr = r[0] > r[1] ? r[0] : r[1];
        result[1] = ml + mr;
        return result;
    }
}
