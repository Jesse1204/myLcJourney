/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || preorder.length!=inorder.length) return null;
        return helper(preorder, inorder, 0, 0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int pre_st, int in_st, int in_end){
        if(pre_st>preorder.length || in_st>in_end) return null;
        TreeNode current = new TreeNode(preorder[pre_st]);
        int i = in_st;
        while(i<=in_end){
            if(inorder[i] == preorder[pre_st]) break;
            i++;
        }

        current.left = helper(preorder,inorder,pre_st+1,in_st,i-1);
        current.right = helper(preorder,inorder,pre_st+(in_st+1),i+1,in_end);

        return current;
    }
}

