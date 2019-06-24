import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        List<Integer> listVal = new ArrayList<Integer>();
        List<TreeNode> listNode = new ArrayList<TreeNode>();
        inorder(root,listVal,listNode);
        Collections.sort(listVal);
        for(int i=0;i<listVal.size();++i){
            listNode.get(i).val = listVal.get(i);
        }
    }

    private void inorder(TreeNode node,List<Integer>listVal, List<TreeNode>listNode){
        if(node==null) return;
        inorder(node.left,listVal,listNode);
        listVal.add(node.val);
        listNode.add(node);
        inorder(node.right,listVal,listNode);
    }

}

