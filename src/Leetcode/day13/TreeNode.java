package Leetcode.day13;

import java.util.HashMap;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack();
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        stack.add(root);
        hashMap.put(root, 1);
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            int depth = hashMap.get(treeNode);
            if (depth > maxDepth) maxDepth = depth;
            if (treeNode.right != null) {
                stack.add(treeNode.right);
                hashMap.put(treeNode.right, depth+1);
            }
            if (treeNode.left != null) {
                stack.add(treeNode.left);
                hashMap.put(treeNode.left, depth+1);
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        Solution solution = new Solution();
        solution.maxDepth(n1);
    }
}
