package Leetcode.day16;

import com.sun.corba.se.impl.encoding.BufferQueue;

import java.util.ArrayDeque;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode left = null;
        while (!queue.isEmpty()) {
            left = queue.peek();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return left.val;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t2.left = t1;
        t2.right = t3;
        Solution solution = new Solution();
        solution.findBottomLeftValue(t2);
    }
}