import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode>queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();

            if(root==null) return res;

            queue.offer(root);

            while(!queue.isEmpty()){
                int curNumber = queue.size();
                List<Integer> cur = new ArrayList<>(curNumber);
                for(int i=0;i<curNumber;i++){
                    TreeNode node = queue.poll();
                    if(node.left!=null) queue.add(node.left);
                    if(node.right!=null) queue.add(node.right);
                    cur.add(node.val);
                }
                res.add(cur);
            }
            return res;
    }
}

