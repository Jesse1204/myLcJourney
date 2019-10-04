/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.left.val!=root.right.val) return false;
        return isSymmetric(root.left) && isSymmetric(root.right);
    }
}

