package Leetcode.day40;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        lists.add(list);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    l.add(treeNode.left.val);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    l.add(treeNode.right.val);
                }
            }
            if (!l.isEmpty()) lists.add(l);
        }
        return lists;
    }
}